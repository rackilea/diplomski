private final List<Float> speeds = new ArrayList<Float>();

public void onLocationChanged(Location location) 
{
    ...
    float speed = ...;

    speeds.add(speed);
}

private float computeAverage(List<Float> values)
{
    float sum = 0;
    for (Float v : values)
    {
        sum += v;
    }
    return sum / values.size();
}

void printSummary()
{
    double average = computeAverage(speeds);
    ...
}