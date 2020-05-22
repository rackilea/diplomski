@Component
public class DemoPOJOHandler {

    public static final String PATH_VAR_ID = "id";

    @Autowired
    private DemoPOJOService service;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<DemoPOJO> entities = service.getAll();
        Mono<List<DemoPOJO>> collected = entities.collectList();

        return collected.map(list -> list.isEmpty() ? 
            ServerResponse.noContent().build() :
            ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(list)
        );
    }
}