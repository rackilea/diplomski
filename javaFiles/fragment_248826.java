comboBox.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(final ItemEvent itemEvent) {
            comboBox.getEditor().setItem(null);
            comboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                        comboBox.getEditor().setItem(itemEvent.getItem());
                    }
                }
            });
        }
    });