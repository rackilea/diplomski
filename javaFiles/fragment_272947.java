public static void main(String[] args) {
    Scanner input = new Scanner (System.in);
    int a,b;
    System.out.println("enter the first number");
    a=input.nextInt(); 

    System.out.println("enter the first number");
    b=input.nextInt();

    boolean result = multiple(a,b);
    System.out.println(result);
}

public static boolean multiple (int g,int c){
    if (g%c==0){
        return true;
    }
    else
    {
        return false;
    }
}