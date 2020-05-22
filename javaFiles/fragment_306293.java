double totalDistance = 0;
for (int i = 0; i < t; i++) {
    int distance = makeExperiment(n);
    totalDistance += distance;
}
double averageDistance = totalDistance / t;