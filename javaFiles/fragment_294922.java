public String dupEachChar2(String str) {

        if(str.length() == 1) 
            return str + str;
        else 
            return str.substring(0,1)+str.substring(0,1)+dupEachChar2(str.substring(1));
    }
}