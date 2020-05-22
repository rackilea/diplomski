List<DataMetrics> result = new LinkedList<>();

for(DataMetrics record : records){
   if(record.name.equals("Client::Sync")){
      result.add(record);
   }
}