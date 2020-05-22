public static Comparator<SchoolTextBook> BookPriceComparator 
                    = new Comparator<SchoolTextBook>() {

    public int compare(SchoolTextBook book1, SchoolTextBook book2) {

        double price1 = book1.getPrice();
        double price2 = book2.getPrice();
        //ascending order
        return Double.compare(price1, price2);

    }

};