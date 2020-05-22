Scanner cin = new Scanner(System.in);
int test = Integer.parseInt(cin.nextLine());

for (int k = 0; k < test; k++) {
    String line  = cin.nextLine();
    Scanner lineScan = new Scanner(line);
    while (lineScan.hasNextInt()) {
        // print number
        System.out.println(lineScan.nextInt());
    }
    //print output
}