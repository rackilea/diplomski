do {
  System.out.println("PREFERRED USERNAME (Only 6 - 14 letters and digits)");
  new_UserName = br.readLine();
  correct = true;
  if(! new_UserName.matches(userName_Pattern) ) {
    System.out.println("Username must contain only letters and numbers, min 8,  max 14");
    correct = false;
  }
} while( ! correct );