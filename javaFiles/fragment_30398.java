package com.example;

import java.util.ArrayList;
import java.util.Random;

public class BookShelf {

    protected ArrayList<Medium> mlist = new ArrayList<Medium>();
    private ArrayList<Integer> idlist = new ArrayList<Integer>();

    private class Medium {
        protected int id;
        protected String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public Medium addMedium(String title) {
        Medium medium = new Medium();
        medium.setId(this.generateID());
        medium.setTitle(title);
        this.mlist.add(medium);
        return medium;
    }

    protected int generateID() {
        Random random = new Random();
        int id;
        do {
            id = 100 + (random.nextInt(999 - 100));
        } while (idlist.contains(id));
        idlist.add(id);
        return id;
    }

    protected boolean delete(Medium delElem) {
        boolean isDeleted = false;
        for (Medium medium : mlist) {
            if (medium.getId() == delElem.getId()) {
                mlist.remove(medium);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    public ArrayList<Medium> getAllBooks() {
        return this.mlist;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Books in the shelf: " + this.getAllBooks().size() + "\n");
        for(Medium medium : this.getAllBooks()) {
            strBuilder.append("Title: " + medium.getTitle() + "\n");
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        //Add two books to the shelf
        Medium medium1 = bookShelf.addMedium("Book 1");
        Medium medium2 = bookShelf.addMedium("Book 2");

        System.out.println(bookShelf.toString());

        //Delete one
        bookShelf.delete(medium1);

        System.out.println(bookShelf.toString());
    }

}