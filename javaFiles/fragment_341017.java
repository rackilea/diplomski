JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

JMenuBar menu = new JMenuBar();
frame.setJMenuBar(menu);
JMenu menuEdit = new JMenu("Edit");
menu.add(menuEdit);
JMenuItem menuEditUndo = new JMenuItem("Undo");
menuEdit.add(menuEditUndo);
menuEditUndo.setAccelerator(KeyStroke.getKeyStroke("control Z"));
menuEditUndo.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("menu");
    }
});

JTextArea textArea = new JTextArea(20, 40);
textArea.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "undo");
textArea.getActionMap().put("undo", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("text");
    }
});
frame.add(new JScrollPane(textArea));

frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);