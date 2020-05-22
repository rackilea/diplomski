// Producer thread (produces serverside data)
obj = readObjFromServer();
sharedQueue.put(obj);  // Blocks if there is already an object waiting

// Consumer thread
obj = sharedQueue.take(); // Blocks until data available
handleData(obj);