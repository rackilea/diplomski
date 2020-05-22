private RConnection rEngine = null;
private int rServePid = -1;

//...

// Keep an opened instance and store the related pid
RConnection rconn = new RConnection();
this.rServePid = rconn.eval("Sys.getpid()").asInteger();
this.rEngine = rconn;
LOG.info("Rserve: started instance with pid '" + this.rServePid + "'.");
//...
this.rEngine.eval("some consuming code...");