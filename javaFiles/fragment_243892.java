while (myFile.hasNextLine()) {

    // get the token **once** and assign it to a local variable
    String text = myFile.nextLine();

    // now use the local variable to your heart's content    
    if(text.equals("Oval")) {
        System.out.println("this is an Oval");

    }

    else if(text.equals("Rectangle")) {
        System.out.println("this is an Rectangle");

    }