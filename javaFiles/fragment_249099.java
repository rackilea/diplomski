public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter a string");
    String str = input.nextLine();
    StringBuilder sb;
    int i;
    for(i=1; i<=str.length(); i++){
        System.out.print(addSpace(str.length()-i) + str.substring(0,i));
        if(i>1){
            sb = new StringBuilder(str.substring(0,i-1));
            sb = sb.reverse();
            System.out.print(sb.toString())
        }
        System.out.println();
    }
    for(i=str.length()-1; i>0; i--){
        System.out.print(addSpace(str.length()-i) + str.substring(0,i));
        if(i>1){
            sb = new StringBuilder(str.substring(0,i-1));
            sb = sb.reverse();
            System.out.print(sb.toString())
        }
        System.out.println();
    }
}
public static String addSpace(int x){
    String s = "";
    for(int i=0; i<x; i++){
        s += " ";
    }
    return s;
}