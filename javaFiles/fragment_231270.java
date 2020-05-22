private static void getWord(String str){
    try {
        if(str != null) {
            System.out.println(str);
        }
    } catch (NullPointerException e) {
        System.out.println("Your word was null.");
    }
}