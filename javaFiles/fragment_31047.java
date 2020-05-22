import java.util.function.Function;
import java.util.Comparator;

class HypotheticComparators {

  public static <A, B> Comparator<A> badCompare1(Function<A, B> f, Comparator<B> cb) {
    return (A a1, A a2) -> cb.compare(f.apply(a1), f.apply(a2));
  }

  public static <A, B> Comparator<A> badCompare2(Function<? super A, B> f, Comparator<B> cb) {
    return (A a1, A a2) -> cb.compare(f.apply(a1), f.apply(a2));
  }

  public static <A, B> Comparator<A> badCompare3(Function<A, ? extends B> f, Comparator<B> cb) {
    return (A a1, A a2) -> cb.compare(f.apply(a1), f.apply(a2));
  }

  public static <A, B> Comparator<A> goodCompare(Function<? super A, ? extends B> f, Comparator<B> cb) {
    return (A a1, A a2) -> cb.compare(f.apply(a1), f.apply(a2));
  }

  public static void main(String[] args) {

    class PhysicalObject { double weight; }
    class Car extends PhysicalObject {}
    class Real { 
      private final double value; 
      Real(double r) {
        this.value = r;
      }
      double getValue() {
        return value;
      }
    }
    class PositiveReal extends Real {
      PositiveReal(double r) {
        super(r);
        assert(r > 0.0);
      }
    }

    Comparator<Real> realComparator = (Real r1, Real r2) -> {
      double v1 = r1.getValue();
      double v2 = r2.getValue();
      return v1 < v2 ? 1 : v1 > v2 ? -1 : 0;
    };
    Function<PhysicalObject, PositiveReal> weight = p -> new PositiveReal(p.weight);

    // bad "weight"-function that cannot guarantee that the outputs 
    // are positive
    Function<PhysicalObject, Real> surrealWeight = p -> new Real(p.weight);

    // bad weight function that works only on cars
    // Note: the implementation contains nothing car-specific,
    // it would be the same for every other physical object!
    // That means: code duplication!
    Function<Car, PositiveReal> carWeight = p -> new PositiveReal(p.weight); 

    // Example 1
    // badCompare1(weight, realComparator); // doesn't compile
    // 
    // type error:
    // required: Function<A,B>,Comparator<B>
    // found: Function<PhysicalObject,PositiveReal>,Comparator<Real>

    // Example 2.1
    // Comparator<Car> c2 = badCompare2(weight, realComparator); // doesn't compile
    // 
    // type error:    
    // required: Function<? super A,B>,Comparator<B>
    // found: Function<PhysicalObject,PositiveReal>,Comparator<Real>

    // Example 2.2
    // This compiles, but for this to work, we had to loosen the output
    // type of `weight` to a non-necessarily-positive real number
    Comparator<Car> c2_2 = badCompare2(surrealWeight, realComparator);

    // Example 3.1
    // This doesn't compile, because `Car` is not *exactly* a `PhysicalObject`:
    // Comparator<Car> c3_1 = badCompare3(weight, realComparator); 
    // 
    // incompatible types: inferred type does not conform to equality constraint(s)
    // inferred: Car
    // equality constraints(s): Car,PhysicalObject

    // Example 3.2
    // This works, but with a bad code-duplicated `carWeight` instead of `weight`
    Comparator<Car> c3_2 = badCompare3(carWeight, realComparator);

    // Example 4
    // That's how it's supposed to work: compare cars by their weights. Done!
    Comparator<Car> goodComparator = goodCompare(weight, realComparator);

  }
}