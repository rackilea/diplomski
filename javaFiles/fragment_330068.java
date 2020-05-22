ArrayList<String> al_designation = new ArrayList<>(Arrays.asList("Developer", "Junior Developer",
            "Senior Developer", "Senior Architect", "Junior Manager", "Senior Manager", "Assistant Manager", //
            "CEO", "Tech Lead", "Dev Lead"));
    System.out.println(al_designation);// Before it contains all
                                        // designations.

    Map<String, String> map = new LinkedHashMap<>();
    for (String designation : al_designation) {
        designation = designation.toLowerCase();
        String[] words = designation.split(" ");
        String lastWord = words[words.length - 1];
        String value = map.get(lastWord);
        if (value == null)
            map.put(lastWord, designation);
        else
            map.put(lastWord, lastWord);
    }
    al_designation.clear();
    al_designation.addAll(map.values());
    System.out.println(al_designation);// Now it contains only required designations. 
                                        //This is your answer.