String correlationID;

if (!Boolean.TRUE.equals(messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY))){
  correlationID=System.currentTimeMillis(); // Better use somtehing more unique
  messageContext.put("INBOUND_ID",correlationID);
}else{
  correlationID= messageContext.get("INBOUND_ID",correlationID);
}