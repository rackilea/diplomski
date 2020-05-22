public static void main(String args[]) {
    int n=Integer.parseInt(args[0]);
    int fac = 1;
    for(int i = n; i >= 2; i--) {
        fac = fac * i;
    }
    System.out.println(fac);
}