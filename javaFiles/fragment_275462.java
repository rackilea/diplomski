Action action = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            stopCellEditing();
        }

       };
       m_textfield.setAction(action);