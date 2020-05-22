protected void initialiseComponent(T component) {
    component.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            stopCellEditing();
        }
    });
}