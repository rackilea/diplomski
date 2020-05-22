boolean isTrue = true;
    outer: for (int i = 0; i < 5; i++) {
        while (isTrue) {
            System.out.println("Hello");
            break outer;
        } // end of inner while
        System.out.println("Outer loop"); // does not print
    } // end of outer loop
   System.out.println("Good Bye");