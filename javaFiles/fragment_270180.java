public static int YOUR_INT_MESSAGE = 100;

class RemindTask extends TimerTask {
    public void run() {
        flag = true;
        System.out.println(" Hello World!");
        for (int e=0; e<2; e++){
            fileToReceive = fileparts.peek();
            System.out.println("fileToReceive "+fileToReceive);
            fileToReceive = fileparts.remove();
        }
        IntegerResult = 4;
        flag=false; 
        Message msg = new Message();
        msg.what = YOUR_INT_MESSAGE;
        msg.obj = IntegerResult;
        YourActivity.this.handler.sendMessage(msg);
    }