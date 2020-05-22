int index = -1;
next.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
            index++;
            text.setText(someText.get(index).getText());
        }
    });