ExecutorCompletionService<Worker> ecs = new ExecutorCompletionService(executorService);
// Worker has to be a callable
// Now you submit your tasks to the ecs:
for (...) {
  ecs.submit(new Worker(...));
}
// Now you block on .take():
while (!(everything is done)) {
  Future<Worker> f = ecs.take();
  // f.get(), for example, to check the results
}