button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent event){
        dal.buttonPressed(data);
    }
});