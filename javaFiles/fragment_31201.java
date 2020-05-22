public class Activator extends DependencyActivatorBase{
    public void init(BundleContext ctx, DependencyManager dm) throws Exception {
        Component logSender = createAspectService(Sender.class, "(foo=bar)", 10)
                .setImplementation(LogSender.class)    
                .add(createServiceDependency().setService(LogService.class).setRequired(true));
        dm.add(logSender);         
    }
}

class LogSender implements Sender {     
    volatile Sender sender;

    @Override
    public void send() {
        log.log(LogService.LOG_DEBUG, "calling method send called on Sender service having properties foo=bar");
        this.sender.send();
    }       
}