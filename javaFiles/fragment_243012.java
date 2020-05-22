/*
URL logoUrl = this.getClass().getResource("/images/login_icon.png"); // you can change this location
Toolkit tk1 = this.getToolkit();   
logo = tk1.getImage(logoUrl);
*/
// use above code if the image lies within your jar file
// otherwise use below code for images stored in path like C:\User\Desktop ..

ImageIcon image = new ImageIcon("C:\\Users\\Public\\Pictures\\Desert.jpg");    
jLabel2.setIcon(image);  // where jLabel2 is your label