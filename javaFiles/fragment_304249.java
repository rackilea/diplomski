SimpleFault fault = new SimpleFault();
 fault.setReason("SimpleFault reason");

 SimpleFaultE faultMessage = new SimpleFaultE();
 faultMessage.setSimpleFault(fault);

 SimpleException ex = new SimpleException("SimpleFault thrown");
 ex.setFaultMessage(faultMessage);

 throw ex;