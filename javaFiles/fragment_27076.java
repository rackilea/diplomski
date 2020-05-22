Activity A
{
public static boolean stopThread = false;
    @Override
    public void onResume()
    {
     super.onResume();
    // put your code here...
     stopThread =false;
     runEventHandler();
     }
private void runEventHandler() {
new Thread() {
    public void run() {
        while (A.stopThread != false) {
            try {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        users.add(new User(10, "a", false));
                        adapter.notifyDataSetChanged();
                    }
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}.start();
}


  @Override
protected void onStop(){
    super.onStop();
    stopThread =true;
   }

}



Activity B
{
public static boolean stopThread = false;
    @Override
    public void onResume()
    {
     super.onResume();
    // put your code here...
     stopThread =false;
     runEventHandler();
     }
private void runEventHandler() {
new Thread() {
    public void run() {
        while (B.stopThread != false) {
            try {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        users.add(new User(10, "a", false));
                        adapter.notifyDataSetChanged();
                    }
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}.start();
}


  @Override
protected void onStop(){
    super.onStop();
    stopThread =true;
   }

}