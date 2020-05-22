tabbedPane.addChangeListener(new ChangeListener() {
    int prev_index = 0;
    int curr_index = 0;

    public void stateChanged(ChangeEvent e) {
        prev_index = curr_index;
        curr_index = tabbedPane.getSelectedIndex();

        System.out.println("Tab (Current): " + curr_index);
        System.out.println("Tab (Previous): " + prev_index);
    }
});