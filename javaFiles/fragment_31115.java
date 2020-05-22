public boolean create(CreateProductUI panel){
 String name = panel.getNameTextField().getText();
 //And the rest of the components which I removed before it's very long

 //I used if else statement to check 
 boolean valid = validateDetails(name,desc,priceStr,qtyStr,dateStr,image,category);

 if(valid) {
     Product product1 = new Product(name,desc,price,quantity,dateStr,image,category);
     product1.create();
 }

 return valid;
 }
}



public boolean validateDetails(String name,String desc,String priceStr,String qtyStr,String dateStr,Image image,int category){

 StringBuilder sb = new StringBuilder();
 if(name.equals("")){
    sb.append(" name ");
 }
 if(desc.equals("")){
    sb.append(" desc ");     
 }
 if(priceStr.equals("")){
    sb.append(" Price "); 
 }
 if(qtyStr.equals("")){
   sb.append(" Quantity ");     
 }
 if(category <= -1){
sb.append(" Category ");    
 }
 String message = sb.toString();
 if(message.length() > 0) {
   JOptionPane.showMessageDialog(null,"Please fill up these values: "+message);
   return false;
 }
 return true;
}