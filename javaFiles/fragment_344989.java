button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        method1();
        method2();
      }
    });

   private void method1(){
     Log.d("Test", "Click handler 1");
   }

   private void method2(){
     Log.d("Test", "Click handler 2");
   }