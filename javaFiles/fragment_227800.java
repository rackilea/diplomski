InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
ActionMap am = getActionMap();

JButton btnC3 = new JButton("");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "c3");
am.put("c3", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        btnC3.doClick();
    }
});
btnC3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // play c
        try {
            keys.playNote(Notes.c3.getValue());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (InvalidMidiDataException e2) {
            e2.printStackTrace();
        }
    }
});

JButton btnD3 = new JButton("");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "d3");
am.put("d3", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        btnD3.doClick();
    }
});