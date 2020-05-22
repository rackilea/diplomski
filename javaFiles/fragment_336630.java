ScriptOperations scriptOps = template.scriptOps();

// Execute script directly
ExecutableMongoScript echoScript = new ExecutableMongoScript("function(x) { return x; }");
scriptOps.execute(echoScript, "directly execute script");     

// Register script and call it later
scriptOps.register(new NamedMongoScript("echo", echoScript)); 
scriptOps.call("echo", "execute script via name");