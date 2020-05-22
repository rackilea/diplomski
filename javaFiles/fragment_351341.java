Map<Integer,String> hm1 = new HashMap<Integer,String>();
String line;
// while there is a line to be read
while ((line = reader.readLine()) != null) {
    // we need to tokenize the line. the common separator is ", "
    // so that it what we shall split it by, to get an array of each value between ", "
    String[] tokens = line.split(",\\s"); //(in regex, \\s matches a whitespace such as a space)
    // if the space is unreliable, it can be made optional: line.split(",\\s?")
    // loop for each record
    for (int i = 0; i != tokens.length; i++) {
        // next we need to get the "data" portion of the record, which is after the '='
        /*
        ** we could use regex again
        ** i.e. tokens[i].split("=")[1] will be the "data"
        ** but as a general rule, if you can do it easily without regex, don't use regex.
        ** it might look innocent enough, but a lot goes on in a regex engine!
        **
        ** instead we just get the index of '=' in the string
        ** add 1 to move past it
        ** and then get the characters from that index onward
        ** i.e. tokens[i].substring(tokens[i].indexOf('=')+1)
        */
        //get the index at which the data starts in the string
        int dataIndex = tokens[i].indexOf('=') + 1;
        //get the chars from that index onward
        String data = tokens[i].substring(dataIndex);
        //insert it into the map
        hm1.put(new Integer(i),data);
    }
}