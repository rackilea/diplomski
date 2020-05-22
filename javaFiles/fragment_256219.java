if (s1.equalsIgnoreCase("hc")) {
            if (mediumHandi == 0) {
                System.out.println("Sorry, the parking space has run out for handicap car.");
                continue;
            }
            mediumHandi--;
            p--;
            System.out.println("Thank you.");
            System.out.println();
        }