ExecutorService executor = Executors.newFixedThreadPool(3);
CompletionService<Void> compService = new ExecutorCompletionService<Void>(executor);

for(int i = 0; i < 3; i++) compService.submit(new Task(), null);

while(true)
{
    compService.take(); // wait until one of the threads finishes its task
    compService.submit(new Task(), null);
}