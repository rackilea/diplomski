@Override
   public String toString() {
        String message;
        message = "[Student] " + _name;
        if (_book == null) { // returns java.lang.NullPointerException
            message += " does not have a book";
        } else {
            message += " is borrowing the book \"" + _book.returnTitle() + "\"";
        }
        return message;
    }