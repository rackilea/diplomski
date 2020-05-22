@Autowired
public Worker(@Value("${company.group.version}") String version, 
              @Value("${company.group.endpoint:#{null}}") String endpoint) {
    this.version = version;
    this.endpoint = endpoint;
    // do work
}