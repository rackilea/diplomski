public class Synchro {

    public static void main(String args[]){
        new Synchro();
    }

    public Synchro(){
        final Moo moo = new Moo();
        Thread t = new Thread(new Runnable(){
           public void run(){
               moo.aMethod("Second");
           }
        });
        t.start();//calling the method in a thread

        moo.aMethod("First");//calling the same method from the same object in the main thread
     }

 class Moo{     
    public Moo(){            
    }

    public void aMethod(String name){
        //this loop just prints slowly so you can see the execution
        for(int i = 1; i <= 100; i++){
            System.out.println(String.format("%s : %d", name, i));
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){}
        }
    }
  }

}