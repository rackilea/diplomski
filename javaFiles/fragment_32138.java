public static int m(int i, int j) {
    static int calls = 0;     
    System.out.println("entering.  count: " + calls);
    calls++;

    System.out.println("i = " + i);
    System.out.println("j = " + j);

    if (i > j) { 
        System.out.println("returning 0");
        return 0;
    } else {
        i++;    
        m(i++, j);
    }

    System.out.println("returning " + i);
    return i;    
}