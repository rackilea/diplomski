while(scanner.hasNextLine()) {
String line = scanner.nextLine();
String[] arr = line.split("\\s+");
 for(String str : arr) {
  if(str.equalsIgnoreCase("M") || str.equalsIgnoreCase("Male")); // check for gender for each line in file.
    gender = "M";
    }
  else if(str.matches("\\d+")) { // check for age.
    age = Integer.parseInt(str);
    }
  else if(firstName!=null || !firstName.isEmpty()) // for string that is not age or gender.
   {
    firstName = str;
   }
  else{
      lastname = str;
     }
}
}