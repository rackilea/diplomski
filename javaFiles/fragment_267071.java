ComboBoxEditor editor = comboBox.getEditor();
    JTextField textField = (JTextField)editor.getEditorComponent();
    textField.addFocusListener( new FocusListener()
    {
        public void focusGained(final FocusEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    JTextField textField = (JTextField)e.getSource();
                    textField.selectAll();
                }
            });
        }

        public void focusLost(FocusEvent e) {}
    });