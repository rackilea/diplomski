static class MyChooser extends JFileChooser {
        protected JDialog createDialog(Component parent)
                throws HeadlessException {
            JDialog dlg = super.createDialog(parent);
            dlg.setLocation(20, 20);
            return dlg;
        }
    }