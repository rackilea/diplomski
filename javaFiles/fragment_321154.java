int myNum = 0;

    try {
        myNum = Integer.parseInt(Spinner_NAME.get(position).toString());
    } catch(NumberFormatException nfe) {
       System.out.println("Could not parse " + nfe);
    }