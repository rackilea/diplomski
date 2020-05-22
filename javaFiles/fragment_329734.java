private class MyListener implements ActionListener {

    Object obj;

    private MyListener(Object obj) {
        this.obj = obj;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        //Operations on obj
    }

}