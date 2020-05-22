String str = null;
     List<String> names = new ArrayList<String>();
     do
     {
      str = JOptionPane.showInputDialog("Enter type of pie");
   if(!str.equalsIgnoreCase("q"))
      names.add(str);
     }while(!str.equalsIgnoreCase("q"));