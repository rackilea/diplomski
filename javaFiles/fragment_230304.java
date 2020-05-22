char passMsg(String akey, char* origMsg){
  // akey = object key must be 4 characters long
  // origMsg + akey must be shorter than 20 characters
  char* newmsg = origMsg;
  size_t prevlen = strlen(newmsg);  
  memset(newmsg + prevlen, ' ', 15 - prevlen);
  *(newmsg + 15) = '\0'; 
  String bleMsg = akey + ":"+newmsg;
  ble.print("AT+BLEUARTTX=");            
  ble.println(bleMsg);  
}