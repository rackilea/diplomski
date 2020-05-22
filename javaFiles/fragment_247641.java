public class ItemDemo {

public enum Item { 
    CANDY("candy"), APPLE("apple"); 
   }

CANDY c;
APPLE a;

public ItemDemo(String name, int age, double money, CANDY c, APPLE a) {
       this.c= c;
       this.a= a;
     }
   }