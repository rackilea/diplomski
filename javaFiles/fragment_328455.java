singlePerform = new AbstractAction("DoSomthing") {

    @Override
    public void actionPerformed(ActionEvent e) {
        setEnabled(false);
        doSomething();
    }
};
JButton button = new JButton(singlePerform);