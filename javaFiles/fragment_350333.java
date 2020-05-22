public static void main(final String[] args) {
    final List<String> plateNumber = new ArrayList<String>(10);
    plateNumber.add("123");

    System.out.println("Plate Numbers to begin with: " + plateNumber.toString());

    System.out.println("Enter your Plate Number : ");
    final Scanner pn = new Scanner(System.in);
    final String plateNumberxx = pn.nextLine();

    System.out.println("Log in / Log out: ");
    final Scanner YoN = new Scanner(System.in);
    final String des = YoN.nextLine();

    if(des.equals("log in")) {
        plateNumber.add(plateNumberxx);
    }

    if(des.equals("log out")){
        plateNumber.remove(plateNumberxx);
        System.out.println("Time log out : " + plateNumberxx + " ");
        System.out.println("Plate Numbers after removal: " + plateNumber.toString());
    }
}