private static void getWord(String str){
    try {
        if(!str.equals(null)) {
            System.out.println(str);
        }
    } catch (NullPointerException e) {
        System.out.println("Your word was null.");
    }
}