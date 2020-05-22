class A {
   int foo () { return 2; }
}

class B extends A {

   boolean someCondition;

   public B(boolean b) { someCondition = b; }

   int foo () { 
       if(someCondition) return super.foo();
       return 3;
   }
}