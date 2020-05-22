List<String> list = new ArrayList<>(Arrays.asList("ROLL_NO","FULL_NAME","PERCENTAGE", "ADDRESS")); 

    int index = list.indexOf("FULL_NAME");

    list.remove(index); //remove "FULL_NAME"

    list.add(index, "LAST_NAME");
    list.add(index, "FIRST_NAME");