List<Principal> users = // fill users
List<Future<UserRecord>> futures = getAllTheFutures(users);
List<UserRecord> results = new ArrayList<>();

for (int i = 0; i < futures.size(); i++) {
        try {
            results.add(futures.get(i).get());
        } catch (InterruptedException | ExecutionException e) {
            // Handle appropriately, results.add(null) or just leave it out
        }
    }
}