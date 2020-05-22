public static void main(String[] args) {

    Body[] bodiesArr = new Body[5];
    Scanner sc=new Scanner(System.in);
    for(int i = 0; i < 5; i++) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        String pic = sc.nextLine();
        Body body = new Body(x, y, pic);
        bodiesArr[i] = body;
    }

}