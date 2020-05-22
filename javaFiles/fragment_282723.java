public String perm(String s){
        v = "";
        boolean used[] = {false, false, false, false, false,false,false};
        permute(0, "", used, s);
        return v;
    }