public String getSubstrings()
    {
        String str="",substr = "";
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; i+j <= word.length(); j++) { //added i+j and equal to comparison
               substr = word.substring(j, i + j); //changed word.substring(i, i + j) to word.substring(j, i + j)
               if("".equals(substr))continue; //removing empty substrings
               str += substr; //added concatenation + operation
               str += "\n";
            }
        }
        return str+word;
    }