@Resource
UserTransaction utx;

@Resource(mappedName="jms/yourConnectionFactory");
ConnectionFactory cf;

@Resource(mappedName="jms/yourQueue");
Queue queue;

..    
Connection conn = null;
Session s = null;
MessageConsumer mc = null;
try {
    utx.begin();
    conn = cf.createConnection();
    s = conn.createSession(true, Session.CLIENT_ACKNOWLEDGE); //TRANSACTIONAL SESSION!
    mc = s.createConsumer(queue);
    conn.start(); // START CONNECTION'S DELIVERY OF INCOMING MESSAGES
    for(int i=0; i<30; i++)
    {
          Message msg = mc.receive();
          //BUSINESS LOGIC
    }
    utx.commit();
} catch(Exception ex) {
  ..
} finally { //CLOSE CONNECTION, SESSION AND MESSAGE CONSUMER
}