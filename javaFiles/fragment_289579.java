final AtomicBoolean success = new AtomicBoolean(false);
final CountdownLatch latch = new CountdownLatch(1);
StringCallback cb = new StringCallback() {
    processResult(int rc, String path, Object ctx, String name) {
        if(name.equals(pathString ) {
            //wait for the last path
            success.set(rc == KeeperException.Code.NODEEXISTS ||
                        rc == KeeperException.Code.OK);
            latch.countDown();
        }
    }
};

StringBuilder path = new StringBuilder();
for (String pathElement : pathParts) {
    path.append(UNIX_FILE_SEPARATOR).append(pathElement);
    String pathString = path.toString();
    //send requests to create all parts of the path without waiting for the
    //results of previous calls to return
    zooKeeper.create(pathString, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, cb);
}
latch.await();
if(!success.get()) { 
    throw ...
}