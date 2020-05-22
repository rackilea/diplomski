public class CategoryFactory {
  public static enum Type {HOUSE, CAR}

  public static Category createCategory(Type type, Param a, Param 2, Param b) {
    if (type == null) return null;

    switch(Type) {
      case HOUSE: return new HouseCategory(a,b,c);
      case CAR: return new CarCategory(a,b,c);
    }
    return null; // or throw exception -> tells, that a new enum is not handled yet
  }
}