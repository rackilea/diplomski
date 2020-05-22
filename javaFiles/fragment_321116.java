interface PathData {
  Path path();
  ExtendedPathData data();
}

final class NullPathData implements PathData {
  Path path;
  public Path path() { return path; }
  public ExtendedPathData data() { return null; }
}

final class ExtendedPathData implements PathData {
  Path path;
  ExtendedPathData data;
  public Path path() { return path; }
  public ExtendedPathData data() { return data; }
}