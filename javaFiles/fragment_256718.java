private final ConcurrentLinkedQueue<Map.Entry<String,Object>> queue = new ConcurrentLinkedQueue<Map.Entry<String,Object>>();
public void run(){
   LinkedHashMap<String, Object> result_ = new LinkedHashMap<String, Object>(lowLevelNetworkOperation_.executeServerCommand(DASHBOARD_INBOX_SENT_COMMAND, params)); 

   for(Map.Entry<String,Object> entry: result_.entrySet()){
      queue.offer(entry);
   }
}