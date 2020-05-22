button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        numberClass.update();
        String numberString = numberClass.numbermethod();           
        textArea.append(numberString);
    }
});