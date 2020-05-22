package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[]args) {

        List<Book> bookList = new ArrayList<>(){{
            add(new Book(4));
            add(new Book(0));
            add(new Book(3));
            add(new Book(7));
            add(new Book(0));
            add(new Book(0));
            add(new Book(1));
            add(new Book(9));
            add(new Book(0));
            add(new Book(5));
        }};

        int booksOutOfStock = 0;

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getQuantity() == 0)
                booksOutOfStock++;
        }

        double percentage = 100d / bookList.size() * booksOutOfStock;

        System.out.printf("Out of total %d books, %d are out of stock, which makes %.2f%%", bookList.size(), booksOutOfStock,
                                                                                                        percentage);
    }
}