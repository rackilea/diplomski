combo.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        String str = (String)combo.getSelectedItem();
        a = str;
        // Comparing strings should use equals, not ==
        if(a.equals("PM1 (Paa/ Spicy Paa with Thigh part)")){
            Wew();
        } else if(a.equals("PM2 (Pecho)")){
            Wew1(); 
        }
    } // <<== Not here: this brace ends the method
}); // <<== It should be after the brace that ends the anonymous class