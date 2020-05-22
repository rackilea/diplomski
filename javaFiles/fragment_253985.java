public class MyFileManager{
  private static MyFileManager instance;

  public static synchronized MyFileManager getInstance(){ // to use as singelton
    if(instance==null){
      instance=new MyFileManager();
    }
    return instance;
  }

  private MyFileManager(){} // to avoid creation of new instances


 public synchronized String read(File f){
   //Do Something
 }

 public synchronized void write(File f, String s){
   //Do Something
 }

}