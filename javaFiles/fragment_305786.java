public class Address{

    ... 
   String city;
   String street;
    ... 

   private Address(){
   }

   public static Address of(A a){
     return new Address(a.getStreet(), a.getCity(), ....);
   }

   public static Address of(B b){
     return new Address(b.getStreet(), b.getCity(), ...);
   }

}