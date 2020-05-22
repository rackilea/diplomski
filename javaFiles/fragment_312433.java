public class GuitarMClass {

    public static void main(String[] args) {

        // OPTION 1
        GuitarFubar output2 = new GuitarFubar();
        output2.setGuitarLength(12.2);
        String mkShft2 = output2.getGuitarLengthAsString();
        System.out.println(mkShft2);

        // OPTION 2
        GuitarFubar bString = new GuitarFubar();
        bString.setGuitarLength(12.2);  //your example code never sets the value of guitarLength, which is why one of your outputs is '0.0'
        System.out.println(Double.toString(bString.getGuitarLength()));

        // OPTION 3
        GuitarFubar guitarFubar = new GuitarFubar(12.2); // actually use the guitar length when constructing a new instance
        System.out.println(Double.toString(guitarFubar.getGuitarLength()));
   }

   public class GuitarFubar {
        private double guitarLength;

        // make sure you have a no-args constructor if that's how you are going to instantiate your class
        public GuitarFubar(){
        }

        public GuitarFubar(double guitarLength){
            this.guitarLength = guitarLength;
        }

        // make sure you have a proper 'getter'
        public double getGuitarLength(){
            return this.guitarLength;
        }

        // make sure you have a proper 'setter'
        public void setGuitarLength(double guitarLength){
            this.guitarLength = guitarLength;
        }

        // alternative to sillyString method if you want this functionality within your GuitarFubar class 
        // (although not required since a caller of getGuitarLength() can handle String conversion)
        public String getGuitarLengthAsString() {
            return Double.toString(this.guitarLength);
        }

    }

}