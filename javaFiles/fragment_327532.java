ActionPane actionPane = new ActionPane();
actionPane.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // The actually history data
        EmployeeHistory history = new EmployeeHistory();
        // This is a model to manage the individual histories, making
        // it easier to manage
        histories.add(history);
        // The history view...
        HistoryPane pane = new HistoryPane(history);
        // The remove action...
        pane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the action to improve the chances of been
                // garbage collected
                pane.removeActionListener(this);
                // Remove the history from our model
                histories.remove(pane.getHistory());
                // Remove the view
                contentPane.remove(pane);
                contentPane.revalidate();
                contentPane.repaint();
            }
        });
        // Add the view (this is a little trick ;))
        contentPane.add(pane, gbc, contentPane.getComponentCount() - 1);
        contentPane.revalidate();
        contentPane.repaint();
    }
});