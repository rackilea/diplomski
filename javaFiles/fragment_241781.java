interface ILogger{

   public void handleEvent (String event);
}

class FileLogger implements ILogger{

   public void handleEvent (String event){
       //write to file
   }
}

class ConsoleLogger implements ILogger{

   public void handleEvent (String event){
       System.out.println( event );
   }
}

class Log {

   public void registerLogger (ILogger logger){

       listeners.add(logger);
   }

   public void log (String event){

       foreach (ILogger logger in listeners){

            logger.handleEvent(event); //pass the log string to both ConsoleLogger and FileLogger!
       }
   }

   private ArrayList<ILogger> listeners;
}