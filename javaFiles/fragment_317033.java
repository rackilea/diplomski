public class JavaPrintArrayWithTwoSeperators {

        public static void main(String[] args) {

            int[] intArray = { 2, 2, 2, 2, 2 };
            for (int i = 0; i < intArray.length; i++) {
                if (i > 0 && i < intArray.length - 1) {
                    System.out.print(", ");
                } else if (i > intArray.length - 2) {
                    System.out.print(" and ");
                }
                System.out.print(intArray[i]);
            }
        }
    }