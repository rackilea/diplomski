public static void main(String args[]) {
    String ll[][] = new String[2][2];
    System.out.println(ll.length);
    System.out.println(ll[1].length);

    for (int i = 0; i < ll.length; i++)
        for (int j = 0; j < ll[1].length; j++)
            ll[i][j] = "true";
    System.out.println();
    System.out.println("All seats are occupied");
    display(ll);
    ll[0][1] = "false";
    ll[1][1] = "false";
    System.out.println();
    System.out.println("Two seats emptied");
    display(ll);
    // adding new one
    System.out.println();
    System.out.println("Adding new passenger");
    addPassenger(ll);
    display(ll);

    System.out.println();
    System.out.println("Adding new passenger");
    addPassenger(ll);
    display(ll);
}

static void display(String a[][]) {

    for (int i = 0; i < a.length; i++)
        for (int j = 0; j < a[1].length; j++)
            System.out.println(i + "" + j + " :: " + a[i][j]);
}

static void addPassenger(String a[][]) {
    boolean result = false;
    for (int i = 0; i < a.length; i++)
        for (int j = 0; j < a[1].length; j++) {
            if (a[i][j] == "false") {
                a[i][j] = "true";
                result = true;
            }
            if (result)
                break;
        }
}

 Output:
 All seats are occupied
 00 :: true
 01 :: true
 10 :: true
 11 :: true

 Two seats emptied
 00 :: true
 01 :: false
 10 :: true
 11 :: false

 Adding new passenger
 00 :: true
 01 :: true
 10 :: true
 11 :: false

 Adding new passenger
 00 :: true
 01 :: true
 10 :: true
 11 :: true