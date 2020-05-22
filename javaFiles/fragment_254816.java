public static void main(String[] args){
     Timer t = new Timer("testTimer", true);
     t.scheduleAtFixedRate(new TimerTask() {
     @Override
     public void run() {
         System.out.println("hello world");
         JOptionPane.showMessageDialog(null, "MSG_Text..");     
     }
     }, 0L, TimeUnit.SECONDS.toMillis(30)); //run will be invoked every 30 seconds 
     while (true) {

        }
    }