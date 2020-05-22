public void run() {
    MyException ex = null;
    while(ex == null) {
        try {
            // Do stuff
        } catch(MyException e) {
            // Maybe handle this exception
            ex = e;
        }
    }
}