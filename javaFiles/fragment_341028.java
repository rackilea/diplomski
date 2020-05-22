Map<Integer,Character> keyWithLetterMap = new HashMap<Integer,Character>();
 //populates initially the map, for instance: keyWithLetterMap.put(input.KEY_A, 'a');

 for (Map.Entry<Integer, Character> keyWithLetter : keyWithLetterMap.entrySet()) {
     if(input.isKeyPressed(keyWithLetter.getKey())) 
        this.text += keyWithLetter.getValue();
 }