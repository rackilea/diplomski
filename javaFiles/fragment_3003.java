public void writer(){

      String x = "MyContacts.txt";
      try {
   PrintWriter outputs = new PrintWriter(x);

       for( int i=0; i < myContacts.length; i++)
         {

          Contact c = myContacts[i];
              if(c!=null){ // check if c is null before writing to file
                 outputs.println(""+c.getName()+" "+c.getNumber()+" "+c.getName());
                 outputs.flush();
            }

      }

          outputs.close();

  }catch (IOException e) {
   e.printStackTrace();


} 
  catch(NullPointerException ex){ // Or just catch the NPE 
  }