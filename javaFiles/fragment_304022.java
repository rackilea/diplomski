List<Officer> workers = new ArrayList<Officer>();
List<Pass> passes = new ArrayList<Pass>();
for ( i=0; i < aryLines.length; i++ ) { 
  String phrase = aryLines[i];
  String div = "[ ]+";
  String[] tokens = phrase.split(div);
  Officer worker = null; // and from this point on use this variable to represent a worker
  Pass workerPass = null; // used to represent a pass
  if (tokens[0].equals("Officer:")){
     if (tokens[1].equals("1")){
        worker = new Worker("1","worker1",1);
        workerPass = worker1.getPass();
        workers.add(worker); // add the worker in the workers list
        passes.add(workerPass); // add the pass in the passes list

     } 
     //etc. for other workers                   
  }