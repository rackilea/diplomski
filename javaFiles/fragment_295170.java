public Set<String> getSupportedOptions() {
    Set<String> set = new HashSet<>();
    set.add("release");
    return set;
  }

  // -Arelease=true
  boolean isRelease(ProcessingEnvironment env) {
    return Boolean.parseBoolean(env.getOptions().get("release"));
  }