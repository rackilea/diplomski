catch(Exception ex) {
    Throwable t = ex.getCause();
    if (t != null && t instanceOf MyException) {
        MyException m = (MyException) t;
        //handle your exception.

    } else {
        //handle other cases
    }
}