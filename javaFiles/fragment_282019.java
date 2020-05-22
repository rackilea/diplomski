public static void main(String[] args) {
    int T=0; String str;
    Scanner sc = new Scanner(System.in);
    T=sc.nextInt();
    for(int i=0; i<T; i++){
       str= sc.next();
       solve(str);
    }
}
public static void solve(String str){
    char first, second; int count=0;
    for(int i=0; i<str.length()-1; i++){
       first= str.charAt(i);
       second= str.charAt(i+1);
       if(first==second){
           count++;
       }
    }
    System.out.println(count);
}