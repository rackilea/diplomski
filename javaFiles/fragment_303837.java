public static class A {
   public String m1(){ //you may need a different method to call from B.m3()
       return this.anotherM2();
   }
   public String m2(){
       return "A.m2() called";
   }
   public String anotherM2() {
       return "A.m2() called";
   }
}