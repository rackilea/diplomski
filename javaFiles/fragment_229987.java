// processing thread
while (!Thread.currentThread().isInterrupted()) {
   dataToWrite = queue.take();
   dataToWrite.setNodeId(myNodeId);
   // process data
   ...
}