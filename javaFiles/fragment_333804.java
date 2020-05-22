import java.lang.*;

public class HelloWorld {
    public static void main(String[] args) {
        String str = "I want this sentence to be split into this form, but how to do. So if anyone can help, that will be great";
        //String delimiters = "\\s+|,\\s*|\\.\\s*";
        String delimiters = "(?<=,)";

        // analyzing the string 
        String[] tokensVal = str.split("(?<=([,.!?;~])+)(?!\\s*(but|and|if))");

        // prints the number of tokens
        System.out.println("Count of tokens = " + tokensVal.length);

        for (String token: tokensVal) {
            System.out.println(token);
        }
    }
}