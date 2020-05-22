public void run(){
   List<Map.Entry> currentEntries = new ArrayList<Map.Entry>();
   Map.Entry  entry = null;
   while((entry = queue.poll())!=null){
       currentEntries.add(entry);
   }
   //use it now
}