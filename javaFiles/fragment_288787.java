month_combo.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(month_combo.getSelectedItem().equals("January")){
            for(int i = 0;i < 31;i++){
                centerPanel.add(method_Btn(i));
            }
        }

        if(month_combo.getSelectedItem().equals("February")){
            for(int i = 0;i < 28;i++){
                centerPanel.add(method_Btn(i));
            }
        }

        centerPanel.revalidate(); // Need to add this for revalidation for the component
    }
});