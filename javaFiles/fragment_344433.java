JButton submit = new JButton(...)
submit.addActionListener(this);
...

public void actionEvent(...) {
    // on submit clicked
    submit.removeActionListener();
    // do the business logic
    submit.addActionListener(this);
}