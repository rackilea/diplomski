if(source == produceBtn){
     String vender = someTextField.getText();
     String weight = someTextField.getText();
     String price = someTextField.getText();
     //perform any conversion from string to numbers if needed.
     /*


     */
     //then create the object
     Produce myProduce = new Produce(vender,weight,price);
     // make sure the order in which you input the data into the arguments of the constructor above is the same as the order in which the constructor definition of the Produce class is.
     produce.add(myProduce);
}