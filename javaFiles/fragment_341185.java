private class PageActionListener implements ActionListener {
    private int page;

    public PageActionListener(int page) {
        this.page = page;
    }

    public void actionPerformed(ActionEvent e) {
        setPage(page);
    }
}

...

for(int i = 0; i < 10; i++){
    button = new JButton(buttons[i]);
    button.addActionListener(new PageActionListener(i));
    menu.add(button);
}