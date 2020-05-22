public static void main (String[] args) throws java.lang.Exception
{
    Scanner input = new Scanner(System.in);

    String userWord, reverse = "";
    int size;
    StringBuilder padding = new StringBuilder();

    System.out.print("Enter a word that is less than or equal to 10 characters: ");
    userWord = input.next();

    userWord = userWord.toUpperCase();
    reverse = new StringBuffer(userWord).reverse().toString();
    size = userWord.length();

    for(int i = 0; i < size; i++){
        padding.append(" ");
    }

    for (int i = 1; i <= size; i++) {
        System.out.print(padding.substring(0, size-i));
        System.out.print(userWord.substring(0, i));
        if(i > 1){
            System.out.println(reverse.substring(size+1-i, size));  //2 >= i  
        }else{
            System.out.println("");
        }
    }
    String pad = padding.substring(0, size-1).toString();
    for(int i = 0; i < size; i++){
        System.out.println(pad + userWord.charAt(i));
    }
}