while (kb.hasNext ()) {

    String in = kb.nextLine ();

    // either 
    // just print it
    System.out.println(in);

    // or split it and iterate
    String arr[] = in.split (" ");
    for (String i : arr) {
       System.out.print(i + " ");
    } 
    System.out.println(" ");
}