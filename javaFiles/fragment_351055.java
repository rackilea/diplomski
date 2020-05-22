class Pali {
    public static void main(String args[]){
       String word = "reliefpfpfeiller";
       char[] let = word.toCharArray();
       for (int i=0; i < let.length / 2; i++ ) {
           if (let[i] != let[let.length - i - 1]){
              System.out.println("this is not palindrome!!!");
              return;
           }
       }
       System.out.println("this is a palindrome!!!");
    }
}