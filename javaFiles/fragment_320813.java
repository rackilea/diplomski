array = new String[4][3]; //Define array here of any appropriate size

do {
    x++;
    int e = x - 1;

    System.out.println("input a : ");
    a = in.nextLine();
    array[e][0] = a;
    System.out.println("input b : ");
    b = in.nextLine();
    array[e][1] = b;
    System.out.println("input c : ");
    c = in.nextLine();
    array[e][2] = c;
    System.out.println("Again ? (y/n)");
    d = in.nextLine();

} while (d.equals("y"));