static List<LockingObject> lockObjects = new ArrayList();
@Override
   public void run(){
       for(LockingObject obj : lockObjects){

           if(Thread.holdsLock(obj)){
               continue; //continue the loop if object is locked.
           }

           synchronized(obj){
               // do things here
           }
       }
   }
}