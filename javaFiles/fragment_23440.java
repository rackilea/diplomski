static void configureMargin(final JTextPane textPane) {
    textPane.addPropertyChangeListener("page", new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent event) {
            updateMargin(textPane);
        }
    });

    textPane.addHierarchyListener(new HierarchyListener() {
        @Override
        public void hierarchyChanged(HierarchyEvent event) {
            long flags = event.getChangeFlags();
            if ((flags & HierarchyEvent.DISPLAYABILITY_CHANGED) != 0) {
                updateMargin(textPane);
            }
        }
    });

    textPane.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent event) {
            updateMargin(textPane);
        }
    });

    textPane.getDocument().addDocumentListener(new DocumentListener() {
        private void updateTextPane() {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    updateMargin(textPane);
                }
            });
        }

        @Override
        public void changedUpdate(DocumentEvent event) {
            updateTextPane();
        }

        @Override
        public void insertUpdate(DocumentEvent event) {
            updateTextPane();
        }

        @Override
        public void removeUpdate(DocumentEvent event) {
            updateTextPane();
        }
    });
}