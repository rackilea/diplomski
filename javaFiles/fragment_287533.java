boolean works=true;
  for(Future<Boolean> future : futures){
        future.get();
        if (future.isDone()) {
            System.out.println("true");
        }
        else{
            System.out.println("false");works=false;
        }
    }
if(works)System.out.println("yea it works")