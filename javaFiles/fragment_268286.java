private void subsets(String word, ArrayList<String> subset){
        if(word.length() == 1){
            subset.add(word);
            return;
        } 
        else {
            String firstChar = word.substring(0,1);
            word = word.substring(1);
            subsets(word, subset);
            int size = subset.size();
            for (int i = 0; i < size; i++){
                String temp = firstChar + subset.get(i);
                subset.add(temp);
            }
            subset.add(firstChar);
            return;
        }
    }