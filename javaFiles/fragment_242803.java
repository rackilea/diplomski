import java.util.*;

class Part {

  public String toString() {

    return getClass().getSimpleName();

  }

  static List<Class> partFactories = new ArrayList<Class>();

  static {

    // Collections.addAll() gives an "unchecked generic

    // array creation ... for varargs parameter" warning.

    partFactories.add(FuelFilter.class);

    partFactories.add(AirFilter.class);

    partFactories.add(CabinAirFilter.class);

    partFactories.add(OilFilter.class);

    partFactories.add(FanBelt.class);

    partFactories.add(PowerSteeringBelt.class);

    partFactories.add(GeneratorBelt.class);
  }


  private static Random rand = new Random(47);

  public static Part createRandom() throws Exception {

    int n = rand.nextInt(partFactories.size());

    return (Part)(partFactories.get(n).newInstance());

  }

}



class Filter extends Part {}

class FuelFilter extends Filter {
}
class AirFilter extends Filter {
}
class CabinAirFilter extends Filter {
}
class OilFilter extends Filter {
}
class Belt extends Part {}
class FanBelt extends Belt {
}
class GeneratorBelt extends Belt {
}
class PowerSteeringBelt extends Belt {
}



public class aa{

  public static void main(String[] args) {

    for(int i = 0; i < 10; i++)

      try {System.out.println(Part.createRandom()); }catch (Exception e) {}

  }

}