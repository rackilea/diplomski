private FocusListener focsListener = new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {
            dumpInfo(e);
        }

        @Override
        public void focusLost(FocusEvent e) {
            //dumpInfo(e);
        }

        private void dumpInfo(FocusEvent e) {
            //System.out.println("Source  : " + name(e.getComponent()));
            //System.out.println("Opposite : " + name(e.getOppositeComponent()));
            //System.out.println("Temporary: " + e.isTemporary());
            final Component c = e.getComponent();
            if (c instanceof JFormattedTextField) {
                EventQueue.invokeLater(new Runnable() {

                    public void run() {
                        ((JFormattedTextField) c).requestFocus();
                        ((JFormattedTextField) c).setText(((JFormattedTextField) c).getText());
                        ((JFormattedTextField) c).selectAll();
                    }
                });
            } else if (c instanceof JTextField) {
                EventQueue.invokeLater(new Runnable() {

                    public void run() {
                        ((JTextField) c).requestFocus();
                        ((JTextField) c).setText(((JTextField) c).getText());
                        ((JTextField) c).selectAll();
                    }
                });
            }
        }

        private String name(Component c) {
            return (c == null) ? null : c.getName();
        }
    };