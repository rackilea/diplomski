private final DoubleSummaryStatistics stats = new DoubleSummaryStatistics();

public void onLocationChanged(Location location) 
{
    ...
    float speed = ...;

    stats.accept(speed);
}

void printSummary()
{
    double average = stats.getAverage();
    double min = stats.getMin();
    double max = stats.getMax();
    ...
}