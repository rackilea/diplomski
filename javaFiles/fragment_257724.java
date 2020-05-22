@Stateless
class Timer {

    @Timeout
    public void doTimeOut(){
       //some code
    }

    @PreDestroy
    public void onShutdown() {

        Logger.getLogger(Timer.class.getName()).log(Level.INFO, "MyBEAN.ShutdownHook execute hook " + hook);
        [...] // some code
    }
}