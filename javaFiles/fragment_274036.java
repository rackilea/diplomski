public class TopicChecker implements MessageListener { 

    PCFMessageAgent           agent; 
    PCFMessage                pcfm; 
    Set<String>               allTopics; 
    TopicConnection           topicCon; 
    TopicSession              topicSes; 
    Topic                     topic; 
    TopicSubscriber           topicSub; 
    JmsTopicConnectionFactory jcf; 
    int                       total; 

    public TopicChecker() throws Exception { 
        allTopics = new HashSet<>(); 
        MQEnvironment.hostname = "myMqServer"; 
        MQEnvironment.channel = "MY.CHANNEL"; 
        MQEnvironment.port = 1515; 
        MQQueueManager m = new MQQueueManager("MY.QUEUE.MANAGER"); 
        agent = new PCFMessageAgent(m); 
        pcfm = new PCFMessage(MQConstants.MQCMD_INQUIRE_TOPIC_STATUS); 
        pcfm.addParameter(MQConstants.MQCA_TOPIC_STRING, "MyRoot/#"); 
        PCFMessage[] responses = agent.send(pcfm); 

        for (PCFMessage response: responses) { 
            /* We only publish to leaf nodes, so ignore branches. */
            if (response.getIntParameterValue(MQConstants.MQIACF_RETAINED_PUBLICATION) > 0) { 
            allTopics.add(response.getStringParameterValue(MQConstants.MQCA_TOPIC_STRING)); 
            } 
        } 

        total = allTopics.size(); 
        agent.disconnect(); 

        jcf = ...
        topicCon = jcf.createTopicConnection(); 
        topicSes = topicCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE); 
        topic = topicSes.createTopic("MyRoot/#"); 
        topicSub = topicSes.createSubscriber(topic); 
        topicSub.setMessageListener(this); 
        topicCon.start(); 
    } 

    @Override 
    public void onMessage(Message m) { 
     try { 
        String topicString = m.getJMSDestination().toString().replaceAll("topic://", ""); 
        allTopics.remove(topicString); 
        System.out.println("Read : " + topicString + " " + allTopics.size() + " of " + total + " remaining."); 
        if (allTopics.size() == 0) System.out.println("---------------------DONE----------------------"); 
        } catch (JMSException e) { 
               e.printStackTrace(); 
        } 
   }


   public static void main(String[] args) throws Exception { 
       TopicChecker tc = new TopicChecker(); 
       while (tc.allTopics.size() != 0); 
   } 
}