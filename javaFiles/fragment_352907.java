for (Entry e : build.getEnvVars().entrySet()) {
  if ("Bool".equals( e.getKey.toString() )) {
    // Do stuff with the Bool variable. To get the value of Bool variable do:
    // e.getValue().toString();
  }
}