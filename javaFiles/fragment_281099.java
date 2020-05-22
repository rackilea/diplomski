input{
   file{    
      type => "system_log"    
      path => "D:\\application\\logstash\\logs\\*"    
   }    
}
output{
   elasticsearch { embedded => true }
}