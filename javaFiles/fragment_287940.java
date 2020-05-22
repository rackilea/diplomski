List<StringSearcher> searchers = new ArrayList<StringSearcher>();

 for (int i = numOfThreads; i > 0; --i) {   
     StringSearcher task = new StringSearcher(file, offset,threadChankSize, args[1],buffSize);
     searchers.add(task);
     tasks.add(service.submit(task));          
 }  
 for (Future<Integer> task : tasks) {         
    result += task.get();         
 }
 for (StringSearcher searcher : searchers){
    /*do stuff with*/ searcher.getRes();
 }