count.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int count = t.getText().length();
        System.out.println(count);
        x.setText(t.getText());
    }
});