public static void main(String args[]) throws Exception {
    Scanner w = new Scanner(System.in);
    String r = "Y", a = "Y";

    while (r.contains(a)) {

        Student s = new Student();
        System.out.println("Enter the marks for maths,physics,chemistry,CSE along with your Reg.no first");
        s.reg = w.nextLine();
        s.maths = w.nextInt();
        s.phy = w.nextInt();
        s.che = w.nextInt();
        s.cse = w.nextInt();
        w.nextLine(); //------> Added
        System.out.println("press 'Y' to continue and 'N' to exit");
        a = w.nextLine();
        s.cal();