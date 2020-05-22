prog = new JProgressBar(0, 100) {
    public void setValue(int newValue) {
        super.setValue(newValue);
        if (newValue >= this.getMaximum()) {
            this.setIndeterminate(false);
        }
    }
};
prog.setValue(0);
...