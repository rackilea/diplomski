@Autowired
public YourBean(@Value("${my.path.to.file}") String path) {
  if (resourceExists) { //your check here
    res = Optional.of(yourExistingResource);
  } else {
    res = Optional.empty();
  }
}