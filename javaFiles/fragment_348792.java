public void adapt(Composite composite) {
        composite.setBackground(colors.getBackground());
        composite.addMouseListener(new MouseAdapter() {
            public void mouseDown(MouseEvent e) {
                ((Control) e.widget).setFocus();
            }
        });
        if (composite.getParent() != null)
            composite.setMenu(composite.getParent().getMenu());
    }