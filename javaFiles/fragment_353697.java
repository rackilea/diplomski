public class Resolve extends Controller {

    private final static String RESOLVER_ACTOR = play.Play.application().configuration().getString("actor.resolve");
    private final static BrainProtoMessages.ResolveReply request_error = BrainProtoMessages.ResolveReply.newBuilder()
        .setReturnCode(BResults.REQUEST_FAILED)
        .build();

    @CorsRest
    @VerboseRest
    @RequireAuthentication
    @BodyParser.Of(BodyParser.Json.class)

public static Result resolve_map() {

    final ResolveRequestInput input;
    final F.Promise<ActorSelection> selected_target;
    final F.Promise<Future<Object>> backend_request;
    final F.Promise<BrainProtoMessages.ResolveReply> backend_reply;
    final F.Promise<ObjectNode> decode_json;
    final F.Promise<Result> ok_result;
    final JsonNode json = request().body().asJson();

    try {
        input = new ResolveRequestInput(json);
    } catch (rest.exceptions.MalformedInputException mie) {
        return badRequest(mie.getMessage());
    }

    selected_target = F.Promise.promise(
      new F.Function0<ActorSelection>() {
          @Override
          public ActorSelection apply() throws Throwable {
              return Akka.system().actorSelection(RESOLVER_ACTOR);    
          }
      }      
    );

    backend_request =
            selected_target.map(
                    new F.Function<ActorSelection, Future<Object>>() {
                        @Override
                        public Future<Object> apply(ActorSelection actorSelection) throws Throwable {
                            return Patterns.ask(actorSelection, input.getMessage(),new Timeout(Duration.create(4, "seconds")));
                        }
                    }
            );

    backend_reply = backend_request.map(

            new F.Function<Future<Object>, BrainProtoMessages.ResolveReply>() {
                @Override
                public BrainProtoMessages.ResolveReply apply(Future<Object> akka_reply) throws Throwable {
                    try {
                        return (BrainProtoMessages.ResolveReply) Await.result(akka_reply, Duration.create(4, "seconds"));
                    }catch(Exception error)
                    {
                        return request_error;
                    }    
                }
            }
    );

    decode_json = backend_reply.map(

            new F.Function<BrainProtoMessages.ResolveReply, ObjectNode>() {
                @Override
                public ObjectNode apply(BrainProtoMessages.ResolveReply response) throws Throwable {
                    return new ResolveOutput(response).getJsonReply();
                }
            }
        );

    ok_result = decode_json.map(
            new F.Function<ObjectNode, Result>() {
                @Override
                public Result apply(ObjectNode reply) {
                    return ok(reply);
                }
            }
    );

    try {
        return ok_result.get(8000);
    }catch(Exception error)
    {
        return internalServerError();
    }

}