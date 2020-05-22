//context
private ConfigurableApplicationContext applicationContext;

//listener state
private ListenerState listenerState = ListenerState.OPEN;

@Override
public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
  this.applicationContext = (ConfigurableApplicationContext) applicationContext;
}
//onMessage method
public void processMessages(....) {
  try {
    process(...);
  } catch (Throwable t) {
    listenerState = ListenerState.ERROR;           
    throw new RuntimeException(...);            
  }    
}

@Override
public void stopContext() {        
  applicationContext.stop();  
}