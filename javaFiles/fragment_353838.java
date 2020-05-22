public class MyTriangleEdge extends EdgeTreatment {

  private final float size;
  private final boolean inside;

  public MyTriangleEdge(float size, boolean inside) {
    this.size = size;
    this.inside = inside;
  }

  @Override
  public void getEdgePath(
      float length, float center, float interpolation, @NonNull ShapePath shapePath) {
    shapePath.lineTo(0, 0);
    shapePath.lineTo(center, inside ? size  : -size );
    shapePath.lineTo(length, 0);
  }