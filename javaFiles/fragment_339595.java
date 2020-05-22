class A {
   void method(B b, C c) {
      b.function(new Listener() {
          public void onValue(long num) { // or any event type
             if (num > 100) C.something();
          }
      });
   }
}