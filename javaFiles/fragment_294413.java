AtomicInteger index = new AtomicInteger(first_page + 1);
for(int i = first_page; i < numberOfPages; ++i){
    es.submit(() -> {
       int page = index.incrementAndGet();
       System.out.println(page);
       String tmpResponse = runRequest("/activity/", page);
       activities.put(page , gson.fromJson(tmpResponse, ActivityResult.class));          
   });
}