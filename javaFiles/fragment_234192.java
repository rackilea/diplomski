StringBuilder lastName;
 String line;
    if (x==1){
    System.out.println ("Please enter your last name, one character at a time.");
    }
    else 
        {System.out.println ("Next letter");}
    line = userInput.nextLine();
    lastName.append(line.substring(0,1));