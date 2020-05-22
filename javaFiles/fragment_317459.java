public void run() {
    try {
        while (true) {
            String str = in.readLine();// client sends suffix "borrowed" or "returned" after
                                       // book's name
            if(str.equals("client_added")){
                String answer1 = book1 + " Stock: " + available1;
                rd.sendR(answer);
                String answer2 = book2 + " Stock: " + available2;
                rd.sendR(answer2);
            }
            if (str.equals(book1 + "borrow")) {// check if the book was borrowed
                available1--;
            ...