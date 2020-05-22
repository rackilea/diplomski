class Base {
   private String v;
   public String getV() { return v; };
   public void setV(String v) { this.v = v; }
}

class A extends Base {
   @Value("${A.v}") public String setV(String v) { super.setV(v); }
}

class B extends Base {
   @Value("${B.v}") public String setV(String v) { super.setV(v); }
}