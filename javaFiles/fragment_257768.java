ThreadForLoopA threadA = new ThreadForLoopA();
ThreadForLoopB threadB = new ThreadForLoopB();

//start threads (the two loops will be executed at the same time)
threadA.start();
threadB.start();