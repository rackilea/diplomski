public static String millisToString(long l){
        long h, m;
        h = l / 3600000;
        m = (l % 3600000) / 60000;
        if(h == 0){
            return m + "m";
        }else{
            return h + "h " + m + "m";
        }
    }