public static int countMatchInString(){
    int result = 0;
    String complexString = "Addf34Dffgh32FxFD345xxxx43";
    Matcher matcher = Pattern.compile("\\P{N}*\\p{Lu}\\P{N}*").matcher(complexString);

    while (matcher.find()){
        result++;
    }
    return result;

}