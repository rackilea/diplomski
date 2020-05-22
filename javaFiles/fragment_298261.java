f.add(new JButton(new AbstractAction("Clear") {

    @Override
    public void actionPerformed(ActionEvent e) {
        doc.setCharacterAttributes(0, doc.getLength(), new SimpleAttributeSet(), true);
    }
}), BorderLayout.SOUTH);