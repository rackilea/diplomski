String s = "This is the work (my real job) which is great, and (also somet stuff";

     ArrayList<String> words = new ArrayList<String>();

     Pattern p = Pattern.compile(" ?([^(][^ ]+|\\([^\\)]+\\)?)");
     Matcher m = p.matcher(s);

     while(m.find()) {
        words.add(s.substring(m.start(),m.end()).trim());
     }

     for(String word : words) {
        System.out.println(word);
     }