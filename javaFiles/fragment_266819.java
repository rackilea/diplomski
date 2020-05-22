// Create Person Objects
  Person p1 = new Person(args[0], age1);
  Person p2 = new Person(args[2], age2);
  String[] outputs = new String[4];

  outputs[0] = p1.toString();
  outputs[1] = p2.toString();

  p1.phd();
  p1.birthday();
  p2.phd();
  p2.birthday();


  outputs[2] = p1.toString();
  outputs[3] = p2.toString();

     //Display a mesage panel in the center of the screen   

  for (String output : outputs) {  
      JOptionPane.showMessageDialog(null, output);
  }