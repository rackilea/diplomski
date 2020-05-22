class A {
    private String a;

    public void setA(String a) {
       if(! "some bad value".equals(a) ) {
           this.a = a;
       }

    }
}