// create a new FileSystem access supplying the result as a SimpleSystem API
 SimpleSystem fs=new FileSystem();  
 // connect to this system with no extra information (e.g. no credentials) and move to the "src" node 
 SimpleNode start = fs.connect("").moveTo("src");
 // do gremlin style out traversals recusively to any depth 
 start.recursiveOut("files",Integer.MAX_VALUE);