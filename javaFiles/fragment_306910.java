public final class JavaKMeans {
  private static final Pattern SPACE = Pattern.compile(" ");

  private Vector call(String line) {
    double[] point = SPACE.splitAsStream(line)
                        .mapToDouble(Double::parseDouble)
                        .toArray();
    return Vectors.dense(point);
  }

  ...
  JavaRDD<Vector> points = lines.map(this::call);
  ...
}