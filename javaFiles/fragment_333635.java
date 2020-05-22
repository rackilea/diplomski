public class MainApplication {

  public static void main(String[] args){

    // MY NON-EFFECTIVELY-FINAL POJO
    NamePojo namePojo = new NamePojo();    // namePojo is assigned.
    namePojo.setName("Luisa");             // namePojo is changed, but not reassigned.

    //MY LAMBDA
    Supplier<String> supplier = () -> {
      // namePojo is changed, but not reassigned.
      namePojo.setName("Alex");  //HOW IS THAT POSSIBLE?!?!
      return "Hello " + namePojo.getName();
    };

    System.out.println(supplier.get());

  }
}