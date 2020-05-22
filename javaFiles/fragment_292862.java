int openOptions = MQC.MQOO_OUTPUT + MQC.MQOO_FAIL_IF_QUIESCING;
Hashtable qMgrProp = new Hashtable();
qMgrProp.Add(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_MANAGED);  /* very important */
qMgrProp.Add(MQC.HOST_NAME_PROPERTY, "10.10.10.10");
qMgrProp.Add(MQC.CHANNEL_PROPERTY, "TEST.CHL");
qMgrProp.Add(MQC.PORT_PROPERTY, 1414);
qMgrProp.Add(MQC.USER_ID_PROPERTY, "myUserID");

try
{
   MQQueueManager _qMgr = new MQQueueManager("MQA1", qMgrProp);

   MQQueue queue = _qMgr.AccessQueue("TEST.Q", openOptions, null, null, null);

   /* Do whatever you want to do */

   queue.Close();
   _qMgr.Disconnect();
}
catch (MQException mqex)
{
   System.Console.Out.WriteLine("MQTest01 cc=" + mqex.CompletionCode + " : rc=" + mqex.ReasonCode);
}