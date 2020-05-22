for (char c = 'A'; c <= 'Z'; c++) {
    JButton btn = new JButton(Character.toString(c));
    btn.addActionListener(new WordActionListener(listOfWords[c - 'A'], this);
    btn.setFocusable(false);
    panel.add(btn);
}