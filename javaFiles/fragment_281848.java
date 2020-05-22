public static void main(String[] args){
    Scanner console = new Scanner (System.in);
    String n = console.next(); 
    Printpalindrome(n);
}

public static void Printpalindrome(String n){
    String reverse = "";
    for ( int i = n.length() - 1; i >= 0; i-- ) {
        reverse = reverse + n.charAt(i);
        System.out.println("re:"+reverse);
    }
    if (n.equals(reverse))
        System.out.println("Entered string is a palindrome."); 
    else
        System.out.println("Entered string is NOT a palindrome."); 
}