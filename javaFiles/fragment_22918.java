//your code here....
Socket Client;
public void run() {
 try {
     Client = new Socket("192.168.1.20", 3333);
     showMessage("Yout MessageBox message here");
    } catch (UnknownHostException e) {
      showMessage("Yout MessageBox message here");
   } catch (IOException e) {
     showMessage("Yout MessageBox message here");
 }

public void showMessage(String message){
  MainActivity.this.runOnUiThread(new Runnable() {
   public void run() {
       // show MessageBox here 
     }
   });
}