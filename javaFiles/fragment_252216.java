final JFileChooser c = new JFileChooser();
        c.setMultiSelectionEnabled(true);
        c.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        c.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (JFileChooser.SELECTED_FILES_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
                    File[] selectedFiles = c.getSelectedFiles();
                    if (selectedFiles.length > 1) {
                        File f=c.getSelectedFile();
                        if (f.isDirectory())
                            c.setSelectedFiles(new File[] {f});
                    }
                }
            }
        });
        c.showDialog(null,"Apply");
        System.out.println(Arrays.asList(c.getSelectedFiles()));