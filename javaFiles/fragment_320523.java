@Singleton
@Path("language")
@Produces(MediaType.APPLICATION_JSON)
public class LanguageResource {
    private final LanguageService langService;

    @Inject
    public LanguageResource(LanguageService dateService) {
        langService = dateService;
    }
}