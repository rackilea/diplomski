...
@Autowired(required = false)
private Bean dependency;

@PostConstruct
private void init() {
  if(dependency==null) {
     // handle missing dependecy
  }
}