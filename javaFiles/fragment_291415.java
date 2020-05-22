do {
            if (scan.hasNextInt()) {
                N = scan.nextInt();
            } else {
                okay = false;
                word = scan.next();
                System.err.print(word + " is an invalid input. Try again. ");
                continue;
            }
            if (N > 100 || N < 1) {
                okay = false;
                System.err.print("Invalid Input. Try again. ");
                continue;
            } else { 
                okay = true;
            }
        } while (!okay);