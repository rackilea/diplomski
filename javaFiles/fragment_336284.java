Button b = new Button();
b.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent evt){
       jButton1ActionPerformed(evt);
       // call the method jButton1ActionPerformed
       // or you can call the one you have defined `hellocalled();` here
    } 
  }
}