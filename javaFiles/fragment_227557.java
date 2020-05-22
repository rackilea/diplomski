public static final StringSplitter DEFAULT_SPLITTER = new StringSplitter() {

    @Override
    public List<String> splitString(String s) {
        List<String> subs = new ArrayList();
        while(!s.isEmpty()){
            int splitsize = 0;
            if(s.length() < 5) {
                if(s.length() == 4) {
                    splitsize = 2;
                } else {
                    splitsize = s.length();
                }
            } else {
                splitsize = 3;
            }
            subs.add(s.substring(0,splitsize));
            s = s.substring(splitsize);
        }
        return subs;
    }


};