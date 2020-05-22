public class ClientThread implements Runnable {
     /*your things*/
     Context mCtx;
     public ClientThread(Context context){
         this.mCtx = context;
         if(context instanceof MainActivity){
             this.callback = (MainActivity) callback;
         }
     }
}