int lineCounter = 0;
while (line != null) {
    // get characters in the line
    for (int j = 0; j < line.length(); j++) {
        // if character is even, it is a node
        ch = line.charAt(j);
        if ((lineCounter+j) % 2 == 0) {
            ...
        } else {
            ...
        }
    }
    line = input.readLine();
    lineCounter++;
}