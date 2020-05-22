int openInputOptions  = MQC.MQOO_INQUIRE + MQC.MQOO_FAIL_IF_QUIESCING + MQC.MQOO_INPUT_SHARED + MQC.MQOO_SAVE_ALL_CONTEXT;
int openOutputOptions = MQC.MQOO_OUTPUT + MQC.MQOO_FAIL_IF_QUIESCING + MQC.MQOO_PASS_ALL_CONTEXT;

MQQueue _inQ = _qMgr.accessQueue( inQueueName, openInputOptions, null, null, null );

MQQueue _outQ = _qMgr.accessQueue( outputQueueName, openOutputOptions, null, null, null );

MQGetMessageOptions getOptions = new MQGetMessageOptions();
getOptions.options = MQC.MQGMO_NO_WAIT + MQC.MQGMO_FAIL_IF_QUIESCING;

MQMessage mqMsg = new MQMessage();

mqMsg.correlationId = MQC.MQCI_NONE;
mqMsg.messageId = MQC.MQMI_NONE;

_inQ.get(mqMsg, getOptions);

MQPutMessageOptions pmo = new MQPutMessageOptions();
pmo.options =  MQC.MQPMO_FAIL_IF_QUIESCING + MQC.MQPMO_PASS_ALL_CONTEXT;
pmo.contextReference = _inQ;

_outQ.put(mqMsg, pmo);