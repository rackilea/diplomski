boolean enableJRadioButton = false;
...
final JRadioButton myRadioButton = new JRadioButton("Do Something");
myRadioButton.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        if ( enableJRadioButton ){
            //do something
        }
    }
});

myButton.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        enableJRadioButton = true;
        //do something else if necessary
    }
});