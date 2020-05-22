public static void setLastname(){
    System.out.println("Please enter: Last Name");
    String lastName = input.nextLine();
    if (lastName.isEmpty()){
    System.out.println("Incorrect input. Either:\n"
            + "1: Fill in last name.\n"
            + "2: Numerics are not allowed; please remove numbers\n"
            + "3: Name is longer than 50 characters; please shorten.\n"
            + "4: No special characters are allowed (e.g: !,@,#,$, etc.);"
            + "please remove special characters\n"
            + "5: No spaces (whitespaces) are allowed; Please fill in without spaces.");                    
    setLastname();
    }
    for (int i = 0; i < lastName.length(); i++){
        if (lastName.length() > 50 || Character.isWhitespace(lastName.charAt(i)) || Character.isDigit(lastName.charAt(i)) || lastName.contains(s1)||  lastName.contains(s2)
        || lastName.contains(s3) || lastName.contains(s4) || lastName.contains(s5) || lastName.contains(s6) || lastName.contains(s7) || lastName.contains(s8)
        || lastName.contains(s9) || lastName.contains(s10) || lastName.contains(s11) || lastName.contains(s12) || lastName.contains(s13) || lastName.contains(s14)
        || lastName.contains(s15) || lastName.contains(s16) || lastName.contains(s17) || lastName.contains(s18) || lastName.contains(s19) || lastName.contains(s20)
        || lastName.contains(s21) || lastName.contains(s22) || lastName.contains(s23) || lastName.contains(s24) || lastName.contains(s25) || lastName.contains(s26)) {
            System.out.println("Incorrect input. Either:\n"
                    + "1: Fill in last name.\n"
                    + "2: Numerics are not allowed; please remove numbers\n"
                    + "3: Name is longer than 50 characters; please shorten.\n"
                    + "4: No special characters are allowed (e.g: !,@,#,$, etc.);"
                    + "please remove special characters\n"
                    + "5: No spaces (whitespaces) are allowed; Please fill in without spaces.");                    
            setLastname();
        }

        }
    }