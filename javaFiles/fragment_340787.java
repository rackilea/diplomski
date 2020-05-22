// 0 means new rows are added as needed
pane.setLayout(new GridLayout(0, 1));

// ...

private void newBranch(){
    // Create the component
    JPanel branch = new JPanel();
    branch.add(new JTextField(20));
    // + any additional subcomponents

    // and just add it where the others already are
    pane.add(branch);
    pane.revalidate();
}