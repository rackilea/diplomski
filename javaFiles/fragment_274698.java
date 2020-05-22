private List<JLabel> labels = new ArrayList<>();

...

public void yourMethod() {

    ...

    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            JLabel newLabel = new JLabel("Label");
            labels.add(newLabel);
            panel.add(newLabel);
            panel.validate();
        }
    });

    ...

}