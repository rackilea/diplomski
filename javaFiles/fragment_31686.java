public static final String SERVER_LOCATION = "127.0.0.1";
public static final int SERVER_BIND_PORT = 5570;
public static final String TOPIC = "topic1";

public static void receiveMessages() throws InvalidProtocolBufferException, FileNotFoundException, UnsupportedEncodingException{
    // Prepare our context and subscribe
       Context context = ZMQ.context(1);
       Socket subscriber = context.socket(ZMQ.SUB);

       subscriber.connect("tcp://"+SERVER_LOCATION+":"+SERVER_BIND_PORT);
       subscriber.setRcvHWM(0);
       subscriber.subscribe(TOPIC.getBytes());
       System.out.println("subscribed to  "+TOPIC);
       int i = 1;
       boolean started = false;
       Timer t = new Timer(timeToSpendSending);
       do{
           String msg = subscriber.recvStr();
           if(!TOPIC.equals(msg)){
               if(!started){
                   t.start();
                   started = true;
               }
               i++;
           }
       }while(!t.isDone());
       System.out.println("Done with: "+i);
       subscriber.close();
       context.term();
   }
   public static void sendMessages() throws FileNotFoundException, UnsupportedEncodingException{
       Context context = ZMQ.context(1);
       Socket publisher = context.socket(ZMQ.PUSH);
       publisher.bind("tcp://"+SERVER_LOCATION+":"+SERVER_BIND_PORT);
       publisher.setHWM(0);
       publisher.setSndHWM(0);

       int i = 1;
       Timer t = new Timer(timeToSpendSending);
       t.start();
       do{
          publisher.sendMore(TOPIC);
          publisher.send("Test Data number "+i);
          i++;
      }while(!t.isDone());
      System.out.println("Done with: "+i);
      publisher.close();
      context.term();
   }