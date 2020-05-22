public static void main(String[] args) throws Exception {
        String sequence = "ABCAABBBABACCACC";
        Base aBase = new Base();

        for (int i = 0; i < sequence.length(); i++) {
            char temp = sequence.charAt(i);
            aBase.getMethod(temp).invoke(aBase);
        }
    }