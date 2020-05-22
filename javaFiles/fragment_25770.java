public class IlikeUFactory {
    private final RestTemplate restTemplate;

    public IlikeUFactory(@Autowired final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public IlikeU createIlikeU(String blub) {
        return new IlikeU(blub, this.restTemplate);
    }
}