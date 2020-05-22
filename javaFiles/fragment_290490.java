String temp = "Ms Abc`<abc@gmail.com`>;Mr Cde`<cde@mail.com`>;Miss Xyz`<xyz@mail.com`>";
     /* Initializing arralists */
    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> email = new ArrayList<String>();

    /* Splitting each record */
    String [] eachRecord = temp.split(";");
    for (int i = 0; i < eachRecord.length; i++) {

        /* Fetch value in each record */
        String [] intermediateValue = eachRecord[i].split(" ");
        title.add(intermediateValue[0]);
        intermediateValue = intermediateValue[1].split("`<");
        name.add(intermediateValue[0]);
        intermediateValue = intermediateValue[1].split("`>");
        email.add(intermediateValue[0]);
    }