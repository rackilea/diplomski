import com.google.api.server.spi.config.Transformer;

public class BarTransformer implements Transformer<Bar, String> {
  public String transformTo(Bar in) {
    return in.getX() + "," + in.getY();
  }

  public Bar transformFrom(String in) {
    String[] xy = in.split(",");
    return new Bar(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
  }
}