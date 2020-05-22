/** convenient "-flag opt" combination */
private class Option {
     String flag, opt;
     public Option(String flag, String opt) { this.flag = flag; this.opt = opt; }
}

static public void main(String[] args) {
    List<String> argsList = new ArrayList<String>();  
    List<Option> optsList = new ArrayList<Option>();
    List<String> doubleOptsList = new ArrayList<String>();

    for (int i = 0; i < args.length; i++) {
        switch (args[i].charAt(0)) {
        case '-':
            if (args[i].length < 2)
                throw new IllegalArgumentException("Not a valid argument: "+args[i]);
            if (args[i].charAt(1) == '-') {
                if (args[i].length < 3)
                    throw new IllegalArgumentException("Not a valid argument: "+args[i]);
                // --opt
                doubleOptsList.add(args[i].substring(2, args[i].length));
            } else {
                if (args.length-1 == i)
                    throw new IllegalArgumentException("Expected arg after: "+args[i]);
                // -opt
                optsList.add(new Option(args[i], args[i+1]));
                i++;
            }
            break;
        default:
            // arg
            argsList.add(args[i]);
            break;
        }
    }
    // etc
}