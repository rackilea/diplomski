@Value("${my.path.to.file}")
private String resourceName;
private Optional<Resoucre> res;

@PostConstruct
private void init() {
  //check that resource exists. At this time all dependencies are already injected.
  if (exists) {
    //init yourResoucre if it is not initialized earlier
    res = Optional.of(yourResource);
  } else {
    res = Optional.empty();
  }
}