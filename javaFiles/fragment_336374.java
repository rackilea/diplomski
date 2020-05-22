// number of lines to print before the ERROR
int numContextLines = // user input

...

Deque<String> contextLines = new LinkedList<String>();
while ((line = br.readLine()) != null) {
    if(line.contains("ERROR")){
        // print out all of the context lines
        for (String contextLine : contextLines) {
            bw.write(contextLine + "\r\n");
        }
        bw.write(line + "\r\n");
    } else {
        // this is not an ERROR message so store it in our list of 
        // context lines that we can print when we find an ERROR
        contextLines.addFirst(line);

        // if this list has gotten too long then throw away the oldest entry in it
        if (contextLines.size() > numContextLines) {
            contextLines.removeLast();
        }
    }
}