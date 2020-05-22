package your.package.structure.adapter;

import your.package.structure.device.DevicePort;
import flex.messaging.messages.AsyncMessage;
import flex.messaging.messages.Message;
import flex.messaging.services.MessageService;
import flex.messaging.services.ServiceAdapter;
import flex.messaging.util.UUIDUtils;

    /**
     * Test service adapter.  Great for testing when you want to JUST SEND AN OBJECT and nothing
     * else.  This class has to stay in the main codebase (instead of test) because, when it's used
     * it needs to be deployed to Tomcat.
     * @author Kevin G
     *
     */

public class TestServiceAdapter extends ServiceAdapter {

    private volatile boolean running;

    private Message createTestMessage() {
        DevicePort objectToSend = new DevicePort("RouterDevice");

        final AsyncMessage msg = new AsyncMessage();
        msg.setDestination(getClass().getSimpleName() + "Destination");
        msg.setClientId(UUIDUtils.createUUID());
        msg.setMessageId(UUIDUtils.createUUID());
        msg.setBody(objectToSend);

        return msg;
    }

    private void sendMessageToClients(Message msg) {
        ((MessageService) getDestination().getService()).pushMessageToClients(msg, false);
    }

    /**
     * @see flex.messaging.services.ServiceAdapter#start()
     */
    @Override
    public void start(){    
        super.start();

        Thread messageSender = new Thread(){
            public void run(){
                running = true;
                while(running){
                    sendMessageToClients(createTestMessage());
                    secondsToSleep(3);
                }
            }
        };

        messageSender.start();        
    }
    /**
     * @see flex.messaging.services.ServiceAdapter#stop()
     */
    @Override
    public void stop(){
        super.stop();
        running = false;
    }
    /**
     * This method is called when a producer sends a message to the destination. Currently,
     * we don't care when that happens.
     */
    @Override
    public Object invoke(Message message) {
        if (message.getBody().equals("stop")) {
            running = false;
        }
        return null;
    }
    private void secondsToSleep(int seconds) {
        try{
            Thread.sleep(seconds * 1000);
        }catch(InterruptedException e){
            System.out.println("TestServiceAdapter Interrupted while sending messages");
            e.printStackTrace();
        }
    }        
}