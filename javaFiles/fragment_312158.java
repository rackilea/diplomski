public class Program {
        public static void main(String[] args) {

        String value = "java";
        char[] array = value.toCharArray();

        // Convert string to a char array.
        for(int i = 0; i < value.length(); i++)
        {
              array[i] = '-';
        }
        // Loop over chars in the array.
        for (char c : array) {
            System.out.print(c);
        }
     }
}