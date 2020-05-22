final Thread t1 = new Thread() {
    public void run(){
        try{
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            Intent First=new Intent("com.example.realtimeassignment.Tasky1");
            startActivity(First);
        }   
    }
};

Thread t2 = new Thread() {
    public void run() {
        try{
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            Intent Second=new Intent("com.example.realtimeassignment.Tasky2");
            startActivity(Second);
        }
        handler1.postDelayed(this, 60000);                               
    }
};

t1.setPriority(Thread.MIN_PRIORITY);
t2.setPriority(Thread.MAX_PRIORITY);

t1.start();
//I need some delay here
final Handler handler - new Handler();
TimerTask task = new TimerTask() {
    public void run() {
       handler.post(new Runnable() {
            public void run(){
               t2.start(); // after 30 sec 2d thread will be executed
               t1.sleep(?) // ? = how long time?
            }
       });
    }
};
Timer timer = new Timer();
timer.schedule(task, 30000L);