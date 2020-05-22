public static void main(String[] args)
{
    System.out.println(reverseWord("Hello world Liondancer"));
}

public static String reverseWord(String str)
{
    int len = str.length();
    String reverse = "", temp = "";

    for (int i = 0; i < len; i++) {   // i == len comparison is unuseful since 'i' won't never be 'len'
        if (str.charAt(i) != ' ') {
            temp = str.charAt(i) + temp; // What you did, but add the current character first, THIS IS THE REVERSE!!!
        } else if (str.charAt(i) == ' ') {
            reverse += temp + " ";
            temp = "";
        }
    }
    reverse += temp; // Added this outside the loop to add last word stored in 'temp'
    return reverse;
}