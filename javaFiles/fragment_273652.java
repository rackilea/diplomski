int choice = 0;

public void actionPerformed(ActionEvent ev){
    if ( choice == 0 ) {
        String whatever = tf.getText();
        if(whatever.equalsIgnoreCase("good"){
        inout.append("blahh");
        ...
        choice++;
    }// end first action
    else if ( choice == 1 ) {
        //Second action
        //Your code for what happens the second time would go here
        choice++;
    } else {
        //you can do this forever
    } 
}