while (responses < futures.size()) {        
   for (Future<ResponseEntity<List<Record>>> future : futures) {
       if (future.isDone()) {
            responses++;
            try {
                ResponseEntity<List<Record>> responseEntity = future.get();
                fullListOfRecords.addAll(responseEntity.getBody());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
        }
    }
}