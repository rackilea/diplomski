List<String> strValues = Arrays.asList("test", "1123.12345 test1",
            "test", "tsest"); // Storing all the values in the List
    List<String> li = new ArrayList<>(); // Creating a new list which will store the updated values of the string

    for (String str : strValues) { // Iterating through the list

        if (str.matches("^[0-9].*$")) { // Checking whether the string starts with a number
            String newString = str.replaceAll("[-+]?([0-9]*\\.[0-9]+)", ""); // This regular expression matches an optional sign, that is either followed by zero or more digits followed by a dot and one or more digits
            li.add(newString); // Adding new string in the list

        }

        else {
            li.add(str); //Adding the old string if the string doesn't start with a number
        }

    }

    for (String newValue : li) {
        System.out.println(newValue); // printing the list
    }

}