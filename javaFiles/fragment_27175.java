@Override
public double cumulativeProbability(int v) {
    return mcp.get((long) v);
}

@Override
public double probability(int v) {
    return mp.get((long) v);
}