for (int i = 0; i < unmixedkey.length(); i++) {
           Random random = new Random();
           int ranpos=0;
           if(unshuffled==1)
           {
               ranpos = 1;
           }else{
               ranpos = random.nextInt(unshuffled - 1);
           }
           char nextchar = inprogresskey.charAt(ranpos);
           mixedkey += nextchar;
           String before = StringUtils.substring(inprogresskey, 0, ranpos);
           String after = StringUtils.substring(inprogresskey, ranpos + 1, unshuffled - (ranpos + 1));
           inprogresskey = before + "" + after;
           unshuffled -= 1;
        }