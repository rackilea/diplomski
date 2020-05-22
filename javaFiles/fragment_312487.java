public static class DoThisThing {
 public String DoThisOtherThing() {
    String hashed = "hello";
    byte[] data = hashed.getBytes("UTF-8");
    String hash = Base64.encodeToString(data, Base64.DEFAULT);
    return hash;
 }
}