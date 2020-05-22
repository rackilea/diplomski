if (len == 1)
    for (int i = 0; i < outputs.get(len - 1).length(); i++)
        outputStrings = outputs;

else {
    ArrayList<ArrayList<String>> tokenizeStrings = new ArrayList();
    // get last n strings from outputs, starts from last
    for (int i = 0; i < len; i++) {
        // transform List<String> into List<List<String>>,
        tokenizeStrings.add( new ArrayList<>(outputs.get(len - (i + 1)).chars()
                .mapToObj(Character::toString)
                .collect(Collectors.toList())));
    }

    outputStrings = new ArrayList<>();
    // reduce
    for (ArrayList<String> list: tokenizeStrings) {
        if (outputStrings.isEmpty()) {
            // first iteration just makes a copy
            outputStrings = list;
        } else {
            ArrayList<String> temp = new ArrayList<>();
            for (String prefix : list) {
                // for the rest iterations use string 'prefix' from current list
                // and add it in front of every string from main list 'outputStrings'
                for (String tail : outputStrings) {
                    temp.add(prefix + tail);
                }
            }
            // replace outputStrings with temp list
            outputStrings = temp;
        }
    }
}

return outputStrings;