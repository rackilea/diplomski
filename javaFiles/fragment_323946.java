@ServiceActivator(inputChannel = "loggerChannel") 
public MessageHandler loggerHandler() {
     LoggingHandler loggingHandler = new LoggingHandler(INFO.name());
     ...  
     return loggingHandler;
}