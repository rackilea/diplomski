protected function audioData():String
{
   var ret:String="";
   buffer.position = 0;                
   while (buffer.bytesAvailable > 0) 
   {
      ret += buffer.readByte().toString();
   }
   return ret;
}