if (patternMap.containsKey(pattern))
    {   
        System.out.println("patternMap contains pattern");
        largestOccurences = generatePattern(word, guess);
        //=> generatePattern changes the global variable pattern, so it may 
        //not be contained in patternMap anymore

        currentWords.add(word);
        currentWords = patternMap.get(pattern);//since pattern was changed, 
                                               //patternMap return null and  
                                         //you get NullPointerException on 
                                         //the next iteration of the loop

        patternMap.put(pattern, currentWords);          
    }