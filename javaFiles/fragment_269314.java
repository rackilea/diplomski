searchTF.addKeyListener(new KeyListener() {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                searchTF.getDocument().addDocumentListener(
                        new DocumentListener() {

                            private void searchFieldChangedUpdate(
                                    DocumentEvent evt) {
                                String text = searchTF.getText();
                                if (text.length() == 0) {
                                    sorter.setRowFilter(null);
                                } else {
                                    try {
                                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text,4));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void insertUpdate(DocumentEvent evt) {
                                searchFieldChangedUpdate(evt);
                            }

                            @Override
                            public void removeUpdate(DocumentEvent evt) {
                                searchFieldChangedUpdate(evt);
                            }

                            @Override
                            public void changedUpdate(DocumentEvent evt) {
                                searchFieldChangedUpdate(evt);
                            }
                        });
            }
        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub
        }
    });