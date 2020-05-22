while (loop3) {
        for (int i=0; i<books.size() && loop3; i++) {

            System.out.println("Search for the book you're looking for: ");
            String book = in.nextLine();

            if (books.get(i).toString().contains(book)) {
                System.out.println("Looking for: " + books.get(i).toString() + "?");
                System.out.println("press y to loan book or n to try again");
                String choice1 = in.next();
                if (choice1.equalsIgnoreCase("y")) {
                    for (int j=0; j<customers.size() && loop3; j++) {
                        if (customers.get(j).getSignedIn()) {
                            customers.get(j).booksLoaned.add(books.get(i)); 
                            Timer.delayFunction();
                            System.out.println(customers.get(j).printBookList()); 
                            System.out.println("Returning to main menu");
                            loop3 = false;    
                        }
                    }
                }
            }
        } 
        System.out.println("Couldnt find book");
    }