public class Deviceplace {

  Set<Class<? extends Geraet>> mErlaubt;

  public Deviceplace(){
    mErlaubt = new HashSet<>();
  }

  public void erlaube(Class<? extends Geraet> clazz) {
    mErlaubt.add(clazz);
  }

  // Option 1: no subtypes of the allowed types
  public boolean isErlaubt(Geraet pGeraet) {
    return mErlaubt.contains(pGeraet.getClass());
  }

  public static void main(String[] args) {
    Deviceplace place = new Deviceplace();
    place.erlaube(Temperatursensor.class);
    System.out.println(place.isErlaubt(new Windsensor()));
    System.out.println(place.isErlaubt(new Temperatursensor()));
  }

}