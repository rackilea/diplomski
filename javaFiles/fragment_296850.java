// Show popup:
                    JPopupMenu popup = new JPopupMenu();
                    for (String fileName : filesWithPrefix) {
                        popup.add(new AbstractAction(fileName) {
                             @Override
                            public void actionPerformed(ActionEvent e) {
                                jTextField1.setText(e.getActionCommand());
                            }
                        });
                    }
                    Point pt = jTextField1.getCaret().getMagicCaretPosition();
                    popup.show(jTextField1, pt.x, pt.y + 5);