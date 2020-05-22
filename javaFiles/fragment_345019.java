// a class that knows how to update the DB given a page of results
class DatabaseUpdater implements Callable { ... }
// a background thread to do the work
final CompletionService<Object> exec = new ExecutorCompletionService(
   Executors.newSingleThreadExecutor());

// first call
List<Object> results = ThirdPartyAPI.getPage( ... );
// Start loading those results to DB on background thread
exec.submit(new DatabaseUpdater(results));

while( you need to ) {
  // Another call to remote service
  List<Object> results = ThirdPartyAPI.getPage( ... );
  // wait for existing work to complete
  exec.take(); 
  // send more work to background thread
  exec.submit(new DatabaseUpdater(results));
}
// wait for the last task to complete
exec.take();