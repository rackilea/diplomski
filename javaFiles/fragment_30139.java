String fullName="Mr Justin raj Savarimuthu";
  Pattern pattern = Pattern.compile(new String ("(Mr\\s|Miss\\s|Mrs\\s)"));
  
  if(fullName.matches("(Mr\\s|Miss\\s|Mrs\\s).*"))
  {
   System.out.println("Salutation:"+fullName.substring(0,fullName.indexOf(' ')));
   fullName=pattern.split(fullName)[1].trim();
  }
  
  String[] parts = fullName.split(" ");
  String firstName="";
  for(int i=0;i<parts.length-1;i++)
  {
   firstName=firstName+parts[i]+" ";
  }
        if(firstName!="")
         System.out.println("FirstName:"+firstName);
        System.out.println("LastName:"+parts[parts.length-1]);