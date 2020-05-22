@Value("${config.folder}:")
private String configFolder;

InputStream = Optional.of(new ClassPathResource(configFolder + "/logback.xml"))
    .filter(r -> r.exists())
    .orElse(new ClassPathResource("classpath:/logback.xml"))
    .getInputStream();