String propFile = "/path/to/file";
Properties props = new Properties();

/* Set some properties here */

Properties tmp = new Properties() {
  @Override
  public Set<Object> keySet() {
    return Collections.unmodifiableSet(new TreeSet<Object>(super.keySet()));
  }
};

tmp.putAll(props);

try {
    FileOutputStream xmlStream = new FileOutputStream(propFile);
    /* This comes out SORTED! */
    tmp.storeToXML(xmlStream,"");
} catch (IOException e) {
    e.printStackTrace();
}