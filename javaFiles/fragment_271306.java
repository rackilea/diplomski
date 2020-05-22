package utils;

public class RUsingStringArray {

        public void useArray(String [] array) {
          for(int i=0; i<array.length; i++ ) {
            String str = array[i];
          }
        }
        public int arrayLen(String [] array) {
                System.out.println("Class: " + array.getClass());
                return array.length;
        }
        public String [] createArray() {
                return new String[0];
        }
        public static void main(String [] arg) {

                RUsingStringArray obj = new RUsingStringArray();
                obj.useArray(obj.createArray());
                System.out.println("Len: " + obj.arrayLen(new String[0]) );
        }
}