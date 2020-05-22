public void createPartControl(Composite parent) {
    // Create view...

    final MouseListener ma = new MouseAdapter() {
        @Override
        public void mouseDown(MouseEvent e) {
            System.out.println("down in " + e.widget);
        }
    };
    addMouseListener(parent, ma);
}

private void addMouseListener(Control c, MouseListener ma) {
    c.addMouseListener(ma);
    if (c instanceof Composite) {
        for (final Control cc : ((Composite) c).getChildren()) {
            addMouseListener(cc, ma);
        }
    }
}