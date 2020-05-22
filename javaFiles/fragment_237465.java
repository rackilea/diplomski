do {
    System.out.println("PREFERRED USERNAME (Only 6 - 14 characters)");
    new_UserName = br.readLine();
    userName_Length=new_UserName.length();
    correct = true;
    if( userName_Length < 6 || userName_Length > 14 ){
        System.out.println("Username must contain 6 - 14 ...");
        correct = false;
    } else
    if(! new_UserName.matches(userName_Pattern) ) {
        System.out.println("Username must contain only letters and numbers");
        correct = false;
    }

} while( ! correct );