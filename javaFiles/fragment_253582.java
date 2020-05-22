int initlength = 20;
    int start = 0;
    String s = "Some people confuse acceptance with apathy, but there's all "
            + "the difference in the world";
    int total = (int) Math.ceil((double) s.length() / (double) initlength);
    for (int i = 0; i < total; i++) {
        if(initlength<s.length()){
            System.out.println("s length" + s.substring(start, initlength));
            start = initlength + 1;
            initlength = initlength + initlength;
        } else {
            initlength = s.length();
            System.out.println("s length" + s.substring(start, initlength));
            break;
        }
    }