private boolean checkAnagram(String stringOne , String stringTwo){
        char[] first = stringOne.toLowerCase().toCharArray(); 
        char[] second = stringTwo.toLowerCase().toCharArray();
        // if length of strings is not same 
        if (first.length != second.length)
            return false;
        int[] counts = new int[26]; 
        for (int i = 0; i < first.length; i++){
            counts[first[i]-97]++;  
            counts[second[i]-97]--;   
        }
        for (int i = 0; i<26; i++)
            if (counts[i] != 0)
                return false;
        return true;
    }