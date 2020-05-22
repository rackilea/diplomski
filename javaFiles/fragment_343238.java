public static String replaceWords(String text, Map<String,String> replacement) {
    String temp = text;

    for(Entry<String,String> entry : replacement.entrySet()){
        temp = temp.replace(entry.getKey(), entry.getValue());
    }

    return temp;
}