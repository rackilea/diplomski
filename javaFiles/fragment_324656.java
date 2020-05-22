public class QueueManagerServices {

final static int MQOO_INQUIRE_TOTAL = CMQC.MQOO_FAIL_IF_QUIESCING | CMQC.MQOO_INPUT_SHARED | CMQC.MQOO_INQUIRE;

MQQueueManager queueManager = null;
String cluster = null;
MQQueue queue = null;

public String getcluster(String host, int portNo, String qMgr, String channelName){

 try{
  queueManager = makeConnection(host, portNo, qMgr, channelName);
  queue = queueManager.accessQueue(queueName, MQOO_INQUIRE_TOTAL);

  int MQCA_CLUSTER_NAME = 2029;
  int MQ_CLUSTER_NAME_LENGTH = 48;

  int[] selectors = new int[1];
  int[] intAttrs = new int[1];
  byte[] charAttrs = new byte[MQ_CLUSTER_NAME_LENGTH];

  selectors[0] = MQCA_CLUSTER_NAME;

  queue.inquire(selectors, intAttrs, charAttrs);

  cluster = new String (charAttrs);

  } catch (MQException e) {
      System.out.println(e);
  } finally {
      if (queue != null){
        queue.close();
      }
      if (queueManager != null){
        queueManager.disconnect();
      }
  }
  return cluster;
  }
 }