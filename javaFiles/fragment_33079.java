ProgressDialog dialog = ProgressDialog.show(GameList.this, "",              "Connecting. Please wait...", true); 

final Handler h = new Handler(); //will execute on the main thread

new Thread(new Runnable(){
public void run()
{
    app.doLogin();
    h.post(new Runnable()
    {
        public void run()
        {
              dialog.dismiss();
        }
    }
}
}).start();