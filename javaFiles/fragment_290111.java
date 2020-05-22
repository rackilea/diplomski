String alphabet = "abcdefghjiklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String eval = "blah";
    Stack<Character> chars = new Stack<Character>();

    for(char c : eval.toCharArray()) {
        if(alphabet.indexOf(c) != -1) {
            chars.push(c);
            System.out.println(chars.pop());
        }
    }