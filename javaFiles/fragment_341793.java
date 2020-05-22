class FirstApp {
    public static void main(String[] args) {
        String sDbStr="0111111110000001234000000000000011";
        StringBuilder sNewStr= new StringBuilder("011111111000000XXXX00000000000001112");
        String findStr = "X";
        int lastIndex = 0;
        System.out.println("Starting");
        long startTime = System.currentTimeMillis();
        String result = replaceValues("X", sDbStr, sNewStr);
        long endTime = System.currentTimeMillis();
        System.out.println("Result");
        System.out.println(result);
        System.out.println(String.valueOf(endTime-startTime));
    }

    public static String replaceValues(String toReplace, String fromStr, StringBuilder toStr) {
        int lastIndex = toStr.indexOf(toReplace);
        if(lastIndex != -1){
            toStr.replace(lastIndex,lastIndex+1,Character.toString(fromStr.charAt(lastIndex)));
            System.out.println(toStr);
            return replaceValues(toReplace, fromStr, toStr);
        } else {
            return toStr.toString();
        }
    }
}