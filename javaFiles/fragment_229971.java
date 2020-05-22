outer: for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            System.out.println("Hello");
            continue outer;
        } // end of inner loop
        System.out.println("outer"); // this won't print
    } // end of outer loop
    System.out.println("Good bye");