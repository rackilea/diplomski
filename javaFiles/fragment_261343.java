public void reportMissingFiles() {
        // Set for containing missing files.
        Set<String> notFoundFileSet = new HashSet<>();
        for (int i = 0; i < listFromFile.size(); i++) {
            if (!listFromDir.contains(listFromFile.get(i))) {
                JOptionPane.showMessageDialog(null, listFromFile.get(i),
                        "File not found", JOptionPane.ERROR_MESSAGE);
                // add missing files in set
                notFoundFileSet.add(listFromFile.get(i).toString());
            }
        }
        JFrame frame = new JFrame("Files Not Found");
        frame.setSize(800, 600);
        frame.setVisible(true);
        JTextField text = new JTextField();
        // Stringify Set of missing file 
        text.setText(notFoundFileSet.toString());
        frame.add(text);
        text.setVisible(true);
    }