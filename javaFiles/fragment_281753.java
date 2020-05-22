private static bool SameLine(IEnumerable<Tuple<int, int>> points) {
  if (null == points)
    return true;

  Tuple<int, int>[] data = points.ToArray();

  // i = 2 - first two points are always on the same line 
  for (int i = 2; i < data.Length; ++i) {
    int x1 = data[0].Item1;
    int y1 = data[0].Item2;

    int x2 = data[1].Item1;
    int y2 = data[1].Item2;

    int xi = data[i].Item1;
    int yi = data[i].Item2;

    // y = k * x + b where k = infinity
    if (x1 == x2) {
      if (xi != x1)
        return false;

      continue;
    }

    // Same k in y = k * x + b
    if (!((y1 - y2) * (xi - x2) == (yi - y2) * (x1 - x2)))
      return false;

    // Same b in y = k * x + b
    if (!((y2 * x1 - y1 * x2) * (xi - x2) == (y2 * xi - yi * x2) * (x1 - x2)))
      return false;
  }

  return true;
}