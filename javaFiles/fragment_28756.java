import java.io.IOException;

import javax.measure.unit.Unit;
import javax.measure.unit.UnitFormat;

public class ScienceUnit {

  public static void main(String[] args) throws IOException {
    Unit<?> meter = Unit.valueOf("m");

    StringBuilder sb = new StringBuilder();
    UnitFormat instance = UnitFormat.getInstance();

    instance.label(meter, "Metre");
    instance.format(meter, sb);

    System.out.println(sb.toString());
  }
}