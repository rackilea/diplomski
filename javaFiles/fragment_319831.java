public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new DataInputStream(new FileInputStream("HelloWorld.java")))); // Reading
                                                                                // the
                                                                                // test
                                                                                // file
        String line;
        int lineNum = 1;
        while ((line = br.readLine()) != null) {
            balanceChecker(line, lineNum);
            lineNum++;
        }
        br.close();
        if (symbolStack.isEmpty()) {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Failure");
        }
    }

    public static void balanceChecker(String line, int lineNum) {
        int charNum = 1;
        Symbol top;
        for (char chr : line.toCharArray()) {
            switch (chr) {
            case '{':
            case '(':
            case '[':
                symbolStack.push(new Symbol(chr, lineNum, charNum));
                break;

            case ']':
                if (symbolStack.isEmpty())
                    System.err.println("Unmatched parentheses ");
                else
                {
                    top = symbolStack.pop();
                    if (top.symbol != '[') {
                        System.err.println("Fail at line: " + top.lineFound
                                + " Column: " + top.colFound);
                    }
                }
                break;
            case ')':
                if (symbolStack.isEmpty())
                    System.err.println("Unmatched parentheses ");
                else {
                    top = symbolStack.pop();

                    if (top.symbol != '(') {
                        System.err.println("Fail at line: " + top.lineFound
                                + " Column: " + top.colFound);
                    }
                }
                break;
            case '}':
                if (symbolStack.isEmpty())
                    System.err.println("Unmatched parentheses ");
                else {
                    top = symbolStack.pop();

                    if ((top.symbol != '{')) {
                        System.err.println("Fail at line: " + top.lineFound
                                + " Column: " + top.colFound);
                    }
                }
                break;
            }
            charNum++;
        }
    }
}