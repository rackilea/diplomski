@Override
public double getVariance() {
    return (sumOfSqrs - ((sum * sum) / count)) / count;
}

@Override
public double getStdDeviation() {
    return Math.sqrt(getVariance());
}