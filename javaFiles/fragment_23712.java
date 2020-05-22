Set<Integer> uniqueMaxOccur = new HashSet<Integer>();  
    for (int i = 0; i < size ; i++) {
        if(occur[i] == maxOccur) {
            //System.out.println(input[i]);
            uniqueMaxOccur.add(input[i]);
        }
    }