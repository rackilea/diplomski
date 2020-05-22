public class Sms extends Controller {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Inject
    private SmsService smsService;

    @BodyParser.Of(value = BodyParser.Json.class)
    public Result invite(){
        ObjectNode result = Json.newObject();
        smsService.sendSms(new ArrayList<String>());
        result.put("status", "OK");
        //cool stuff ehere
        return ok(result);
    }
}