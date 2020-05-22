public void make(){  
      registerUpdateHandler(new IUpdateHandler(){             
           @Override
           public void onUpdate(float cookTime){
                // need to do some modifications to pizza
                doSomething();
                doSomethingElse();
           }
      });
 }