public class SimpleArray  {

        public static void main(String args[]) {

            int[] myArray = new int[100];

            for (int i = 0; i < myArray.length; i++) {
                myArray[i] = i + 500;
            }   

            for (int i = 0; i < myArray.length; i++) {
                System.out.println(myArray[i]);
            }

        }

    }