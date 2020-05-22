class Test {
    public static void main(String[] f) {
        JFrame myFrame = new JFrame();
        myFrame.add(new Time());
        myFrame.setVisible(true);
    }
}

class Time extends JSpinner {

    public Time() {
        super();
        SpinnerDateModel SpinnerModel = new SpinnerDateModel();
        this.setModel(SpinnerModel);

        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(this, "hh:mm a");
        this.setEditor(dateEditor);
    }
}