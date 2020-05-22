String name      = "אבגa";
        char[] charArray = name.toCharArray();
        for (char c : charArray) {
            if (c <= 0x05ea && c >= 0x05d0) {
                System.out.println("Valid hebrew");
            }
        }