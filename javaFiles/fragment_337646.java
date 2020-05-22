buttonClick.addActionListener(new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
        if(clicks <= 15){
            updateCounter();
       }else{
         //whatever you want to do   
        }
    }});