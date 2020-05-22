public class HelloWorld {

     public static void main(String []args) {
        char[] string = {'t', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 's', 't', 'r', 'i', 'n', 'g', 0};
        char[] substring = {'i', 's', ' ', 0};
        int c = 0;
        Boolean found = false;
        int position = 0;

        while (string[c] != '\0') {
            int f = 0;
            while (string[c+f]==substring[f]) f++;
                if (substring[f]=='\0') {
                    found = true;
                    position = c;
                }
            c++;
        }
        if (found)
            System.out.println("found at position " + position);  
    }
}