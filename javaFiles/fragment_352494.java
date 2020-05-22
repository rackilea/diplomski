String addParentheses(String text) {       
        Pattern ps = Pattern.compile("(\\s)*(\\([^\\)]*\\))(\\s)*"); //Find everything surrounded by (), 'eating' the spaces before and after as well.
        Matcher m=ps.matcher(text);
        StringBuffer output = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(output, " $1 ");  //Surround with spaces, replacing any existing one 
        }

        m.appendTail(output);
        return output.toString().trim(); //Remove trailing spaces
}