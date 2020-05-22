@Autowired
private ResourceLoader resourceLoader;

...

@PostConstruct
private void init() {
    String resourceReference = environment.getProperty("myFile.path");
    Resource resource = resourceLoader.getResource(resourceReference);
    if (resource != null) {
        myFile = resource.getFile();
    }
}