public MyOtherClass implements Cloneable {
     public Object clone() {
         super.clone();
     }
 }

 public MyOtherClass {
     private MyClass m;

     public MyOtherClass(MyClass m) {
         this.m = m.clone();  // Defensive copy.
     }
 }

 public SneakyClass extends MyClass {
     public clone() {
         return this;         // !!!!!!
     }
 }