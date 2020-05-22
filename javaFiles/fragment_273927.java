public class SquareUser {

        public static void main(String[] args) {

            //Create an instance of array sqArray.
            Square[] sqArray = new Square [10];

            for(int i = 0; i < sqArray.length; i++) {

                int val = 10 + (int) (Math.random()*10);
                sqArray[i] = new Square(val);
                System.out.println("Length is "+val);
                System.out.println("Area is "+sqArray[i].calculateArea());
            }
        }
    }