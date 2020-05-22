public static ArrayList<Book> commonBooks(Person a, Person b) {

ArrayList<Book> personA = a.getRead();
ArrayList<Book> personB = b.getRead();
ArrayList<Book> sameBooks = new ArrayList<Book>();

if (personA.size() < personB.size()) {
    for (int i = 0; i < personA.size(); i++) {
        Book ndx = personA.get(i);
        if (personB.contains(ndx)) {
            sameBooks.add(ndx);
        } else if (personB.size() < personA.size()) {
            for (int i1 = 0; i1 < personB.size(); i1++) {
                Book ndx1 = personB.get(i1);
                if (personB.contains(ndx1)) {
                    sameBooks.add(ndx1);
                } else if (personB.size() < personA.size()) {
                    for (int i2 = 0; i1 < personB.size(); i2++) {
                        Book ndx2 = personB.get(i2);
                        if (personB.contains(ndx2)) {
                            sameBooks.add(ndx2);
                        }

                    }
                } else {
                    //return sameBooks;
                    break;
                }

            }
        }
    }
} 

return sameBooks;


}