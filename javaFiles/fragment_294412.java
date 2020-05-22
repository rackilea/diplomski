AtomicInteger index = new AtomicInteger(first_page +1);
for(index.get(); index.get() < numberOfPages; index.incrementAndGet()){
    es.submit(new Runnable() {
        @Override
        public void run() {
             System.out.println(index.get());
             String tmpResponse = runRequest("/activity/", index.get());
             activities.put(index.get(), gson.fromJson(tmpResponse, ActivityResult.class));          
        }
    });
}