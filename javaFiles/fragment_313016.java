// In PoolDemo
// This part is the same, just so you know where we are
for(int i = 0; i<Iterations; i++) {
    Task t = new Task(i);
    executor.execute(t);
}

// CHANGES BEGIN HERE
// Will block till all tasks finish. Required regardless.
executor.shutdown();
executor.awaitTermination(10, TimeUnit.SECONDS);

for(int j=0; j<FileArray.length; j++){
    long duration = FileArray[j];
    TotalTime += duration;

    if (duration < FastestMemory) {
        FastestMemory = duration;
    }

    if (duration > SlowestMemory) {
        SlowestMemory = duration;
    }

    new PrintStream(fout).println(FileArray[j] + ",");
}

. . . 

// In Task
// Ending of Task.run() now looks like this
long Finish = System.currentTimeMillis();
long Duration = Finish - Start;
FileArray[this.ID] = (int)Duration;
System.out.println("Individual Time " + this.ID + " \t: " + (Duration) + " ms");