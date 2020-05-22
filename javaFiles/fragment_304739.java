Scanner Sc = new Scanner (System.in);
int n = Sc.nextInt();
for(int count = 1;count<=n; count++){
    String w = Sc.nextLine();
    if(w.length() > 4){
        System.out.print(w.charAt(0));
        System.out.print(w.length()-2);
        System.out.print(w.chatAt(w.length()-1));
    }
    else{
        System.out.println(w);
    }
    System.out.println();
}