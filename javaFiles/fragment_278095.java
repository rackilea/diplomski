@Override
protected void finalize() throws Throwable  {
    try {
        System.out.println("bye");
        _future.cancel(true);
    } finally {
        super.finalize();
    }       
}