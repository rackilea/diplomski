EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        Test t = new Test();
        t.getLineCount();
    }
});