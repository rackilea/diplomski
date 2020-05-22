public class DBDIalog extends JDialog{
     private JLabel busyLabel = new JLabel("Fetching data from DataBase");

     public DBDialog(){
         //do your initialization stuff here
     }

     private class DBFetcher extends SwingWorker<Void,DBInfo>{

        @Override
        protected DBInfo doInBackground() throws Exception{
            return fetchDataFromDB(); //or whatever database call to make
        }

        @Override
        protected void done(){
           try{
               DBInfo info = get();
           //replace your busy label with your DBInfo
           }catch(InterruptedException e){
              //do appropriate thread interrupted stuff
           }catch(ExecutionException e){
              //do appropriate general error handling stuff 
           }

        }
     }
}