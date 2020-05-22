finally {
  if (channelTarget != null) {
       channelTarget.exit();     
       channelTarget.disconnect();  
  }
  if (sessionTarget != null ) {
       sessionTarget.disconnect();  
  }
}