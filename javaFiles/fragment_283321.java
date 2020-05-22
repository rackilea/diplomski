int N = 10000;

startTimer();
for (int i = 0; i < N; i++) {
  runExperiment();
}
stopTimer();

double averageRuntime = timer / N;