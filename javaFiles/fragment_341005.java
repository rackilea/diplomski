// as mentioned by AndrewBissell, there is no reference to the bundle
// luckily, we only need the direction from the bundle :)
private final int _direction;

WeightedEdge(Bundle bundle, Vertex target, int weight) {
    this(bundle.getDirection(), target, weight);
}

WeightedEdge(int direction, Vertex target, int weight)
{
    _direction = direction;
    _weightedEdgeComparator = new EdgeComparator(_direction);
    _target = target;
    _weight = weight;

}

WeightedEdge updatedObject(int newWeight)
{
    return new WeightedEdge(_direction, _target, newWeight);
}