interface Checkable{
  String doCheck();
}

class Plan {
     public enum Type implements Checkable{
         FOO{
            @Overide public String doheCheck() {
               return "result of Foo check";
            }
         }, BAR{
            @Overide public String doheCheck() {
               return "result of Bar check";
            }
         };
     }

     String check() {
          for(Checkable checkable: Type.values()){
              checkable.doCheck();
     } 


      String doSomething() {
     }
}