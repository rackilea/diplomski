static boolean isNeverAsync = false;

  static {
    var env = System.getenv().get("asyncc_exclude_redundancy");
    isNeverAsync = env != null && env.equals("yes");
  }