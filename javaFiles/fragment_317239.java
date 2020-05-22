public static void main(String[] args) throws Exception{
    int i;
    int count = 1;
    for (i=1;i<=100;i++) {
        System.out.print(i);
        if(count % 5 == 0) {
                System.out.print("*");
        }else if(count % 8 == 0) {
                System.out.print("*");
                count = 0;
        }
        count++;
    }
}