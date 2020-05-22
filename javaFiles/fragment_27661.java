public static void main(String[] args) {
        String in = "asdf don't ]'.'..;'' as12....asdf.\nasdf";

        //The pattern: 
        Pattern p = Pattern.compile("[\\p{Alpha}][\\p{Alpha}']*|'[\\p{Alpha}]+");

        Matcher m = p.matcher(in);
        //If you want to collect the words
        List<String> words = new ArrayList<String>();

        StringBuilder result = new StringBuilder();

        Now find something from the start
        int pos = 0; 
        while(m.find(pos)) {
            //Add everything from starting position to beginning of word
            result.append(in.substring(pos, m.start()));

            //Handle dictionary logig
            String token = m.group();
            words.add(token); //not used actually
            if(!inDictionary(token)) {
                token = correctSpelling(token);
            }
            //Add to result
            result.append(token);
            //Repeat from end position
            pos = m.end();
        }
        //Append remainder of input
        result.append(in.substring(pos));

        System.out.println("Result: " + result.toString());
    }