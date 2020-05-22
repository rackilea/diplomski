// Create PCF Message Agent
try {
    pcfAgent = new PCFMessageAgent(qmgr);
} catch (MQException mqe) {
    System.err.println("PCF Message Agent creation ended with reason code "
                       + mqe.reasonCode);
    return mqe.reasonCode;
}