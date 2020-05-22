public void solve(String str) {
    for(int i=1;i<=str.length()/2;i++) {
        for(int j=str.length()/2-i; j>0 ;j--) {
            System.out.print(" ");
        }
        System.out.print(str.substring(0,i));
        System.out.print(str.substring(str.length()-i));
        System.out.println();
    }
}