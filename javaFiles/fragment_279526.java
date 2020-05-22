if (book1.equals(b)){
        p.addBook(book1);
        removeBooks.add(book1);
        book1.setDueDate(dueDate);
        b.setCheckedOut(true);
        System.out.println("Checked out!");
        break;
    }