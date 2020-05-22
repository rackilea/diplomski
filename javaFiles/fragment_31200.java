public class Activator extends DependencyActivatorBase{
    public void init(BundleContext ctx, DependencyManager dm) throws Exception {
        Component logSender = createAspectService(Sender.class, null, 10, "setSender", null, null)
                .setImplementation(LogSender.class)    
                .add(createServiceDependency().setService(LogService.class).setRequired(true));
        dm.add(logSender);         
    }
}

class LogSender implements Sender {     
    volatile Sender sender;
    volatile Map<String, Object> senderProperties;
    volatile LogService log;

    void setSender(Sender sender, Map<String, Object> senderProperties) {
        this.sender = sender;
        this.senderProperties = senderProperties;
    }

    @Override
    public void send() {
        if ("bar".equals(senderProperties.get("foo"))) {
            log.log(LogService.LOG_DEBUG, "calling method send called on Sender service having properties foo=bar");
        }
        this.sender.send();         
    }       
}