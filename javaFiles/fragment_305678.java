class A {
   private String name;  // internal private attribute (variable) for class A

   public String getName() {  // public access method for attribute "name"
       return name;
   }
}

class B {
   private A instanceOfA;   // internal private reference to class A

   public B(A instanceOfA) {   // public constructor of class B, which requires an instance of A as a parameter
        this.instanceOfA = instanceOf;
   }

   public void doNothing() {  // example method accessing A's attribute "name"
         System.out.println(instanceOfA.getName());
   }
}