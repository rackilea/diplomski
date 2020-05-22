List<DATA> queue = new List<DATA>();
queue.Sort(
    (left, right) => {
        double distance1 = distanceFunction.Calculate(left, promoted.first);
        double distance2 = distanceFunction.Calculate(right, promoted.first);
        return Double.Compare(distance1, distance2);
    }
);