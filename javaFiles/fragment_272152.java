...
public void runService(IndexService service) {
     service.index()
}

// some where in your code
runService(new AsyncIndex());
// or
runService(new SyncIndex());