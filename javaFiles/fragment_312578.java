mExecutor.shutdownNow();
// Prepare Scroller data
mExecutor =  Executors.newCachedThreadPool();//or other pool which u need

mExecutor.execute(new Scroller(destination, speed));
By this way u can go.