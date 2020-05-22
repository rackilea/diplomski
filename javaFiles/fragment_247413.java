public class PNRExpirationThread extends Thread {
    @Override
    public void run() {
        while (true) {  //or while !stop, or while Server.isRunning(), you get the idea
            try {
                Thread.sleep(30000);  //wait 30 seconds; adjust this to your liking
                //it's pseudo-SQL, but you get the idea; I'm assuming your data model has the required fields for this to work
                Database.executeTxn("DELETE FROM pnrRecords WHERE NOW() - createDate > 12h AND confirmed = 0");  
            }
            catch (Throwable ignored) {
            }
        }
    }
}