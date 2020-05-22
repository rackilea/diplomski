public class ADTbag {
       String item = "Testing";
       String[] bag;

       public ADTbag(int size) {
          // This constructor has one parameter, name.
         this.bag = new String[size];

          bag[0] = Integer.toString(size);
          System.okaut.println("A bag was created with the size of " + size + " | " + bag[0]);
       }

       public void insert() {
          /* Insert an item */
          /* One Problem this public void doesn't have access to the bag var"
          System.out.println(bag);*/

       }
}