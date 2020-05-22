interface Furniture {}

class Test {
   public static void main(String[] args) {
       Furniture f; Cat cat = new Cat();
       f = (Furniture)cat; //runtime error
   }
}