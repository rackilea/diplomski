public static void main(String [] args){

     Log myLog();
     FileLogger myFile();
     ConsoleLogger myConsole();

     myLog.registerLogger( myFile );    
     myLog.registerLogger( myConsole );

    myLog.log("Hello World!!");
    myLog.log("Second log event!");
}