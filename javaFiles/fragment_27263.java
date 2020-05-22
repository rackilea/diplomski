Thread thread = new Thread(new Runnable(){
@Override // only add this if required
public void run(){
       try{
              // code here
              Thread.sleep(AmountOfTimeInMilliSeconds);
        catch(Exception e){
              e.printStackTrace();
        }
});
thread.start();