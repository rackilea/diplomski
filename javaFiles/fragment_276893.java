String[] arr = new String[1];
    arr[0] = "rohit";
    List<String> newList = Arrays.asList(arr);

    // Will throw `UnsupportedOperationException
    // newList.add("jain"); // Can't do this.

    ArrayList<String> updatableList = new ArrayList<String>();

    updatableList.addAll(newList); 

    updatableList.add("jain"); // OK this is fine. 

    System.out.println(newList);       // Prints [rohit]
    System.out.println(updatableList); //Prints [rohit, jain]