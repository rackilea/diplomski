public A() {
       myBClass = new B() {
            @Override
            public void doSomething() {
                super.doSomething();
                //do here what you need what you want to do in B class
            }
       }
       myBClass.doSomething();
       //Continue doing other tasks
   }