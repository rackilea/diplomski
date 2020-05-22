void process() {

    Iterator fileIterator = fileContent.iterator();

    int state = 0;
    String token = "";  // notice this
    switch (state) {

    case 0:
        token = ((String)fileIterator.next()).trim();  // notice this
        if (token.equals("Table")) {
            System.out.println(token);
            state = 1;
        } else {
            System.err.println("Corrupt file format at state 0: "+ token);
            System.exit(0);
        }
        break;
    }

}