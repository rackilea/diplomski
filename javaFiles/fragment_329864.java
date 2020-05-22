fc = new JFileChooser() {

        @Override
        public void setSelectedFile(File file) {
            super.setSelectedFile(file);
            ((BasicFileChooserUI) getUI()).setFileName(getName(file));
        }

    };
    fc.setFileView(new MyView());