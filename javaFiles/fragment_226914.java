public class MyNativeObject{

     private boolean released = false;

     public synchronized String read(){
         return released ? null : Read(); 
     }

     public synchronized void release(){
         if(released) return;
         released = true;
         Release();
     }

     // make the native methods static if you can.
     private static native String Read();
     private static native void Release();
}