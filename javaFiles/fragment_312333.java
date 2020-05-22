MPI.Init(args);
int myrank = MPI.COMM_WORLD.Rank();
long startTime = System.nanoTime();
if (myrank == 0) {
     ...
} else {
      ...
}

long endTime = System.nanoTime();
long duration = endTime - startTime;