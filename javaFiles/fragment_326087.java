private Map<String, String> other = new HashMap<String, String>();

  @JsonAnyGetter
  public Map<String, String> any() {
   return other;
  }

 @JsonAnySetter
  public void set(String name, String value) {
   other.put(name, value);
  }