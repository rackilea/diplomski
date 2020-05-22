List<Future> futures = new ArrayList<>(keys.size());
for(DataKey key : keys) {
    Future<DataResponse> future = executeAsync(key);
    futures.add(future);
}

for (Future<DataResponse> future : futures) {
    try {
        responseList.add(future.get());
    } catch (Exception e) {
        // do something else.
    }
    return responseList
}