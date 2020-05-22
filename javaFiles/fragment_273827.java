mqMsg.seek(0);
MQDLH dlh = new MQDLH(mqMsg);
System.out.println("Reason code= "+dlh.getReason() + " : Dest. Queue Name="+dlh.getDestQName());

byte[] bData = new byte[mqMsg.getDataLength()];
mqMsg.readFully(bData);

// Open the original destination queue
int openOutputOptions  = CMQC.MQOO_OUTPUT + CMQC.MQOO_FAIL_IF_QUIESCING;
MQQueue outQ = _qMgr.accessQueue( dlh.getDestQName().trim(),
                                  openOutputOptions,
                                  dlh.getDestQMgrName().trim(),
                                  null,
                                  null );

// Create a new message and set the values from DLH
MQMessage newMsg = new MQMessage();
newMsg.characterSet = dlh.getCharacterSet();
newMsg.encoding     = dlh.getEncoding();
newMsg.format       = dlh.getFormat();

newMsg.write(bData);  // write the data

MQPutMessageOptions pmo = new MQPutMessageOptions();
pmo.options =  CMQC.MQPMO_FAIL_IF_QUIESCING;

// Put the message to the destination queue
outQ.put(newMsg, pmo);

outQ.close();