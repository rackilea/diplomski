for (String key:keys){
        String value = mapOfStrings.get(key);
        //here it must uderstand, that the inputText contains "java" that equals to
        //the key="java" and put in outputText the correspondent value
        if (inputText.contains(key))
        {
           outputText = value;
        }
    }