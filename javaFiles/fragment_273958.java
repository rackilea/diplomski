enum MyEnum {

   FOO, BAR;

   private MyEnum() {
        // Illegal
        // FOO already calls this constructor
        System.out.println(FOO);
   }

}