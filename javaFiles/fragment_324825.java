public String format(LogRecord record){
  if(record.getLevel() == Level.INFO){
    return record.getMessage() + "\r\n";
  }else{
    return super.format(record);
  }
}