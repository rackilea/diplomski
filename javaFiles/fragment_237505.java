public static String encodeListString(ArrayList<String> stringList){
    StringBuilder stringbuilder = new StringBuilder();
    stringbuilder.append(stringList.get(0));
    if(stringList.size() > 1){
        for( int i = 0; i < stringList.size(); i++){
            stringbuilder.append(",");
            stringbuilder.append(stringList.get(i));
        }
    }

    return stringbuilder.toString();
}

public static List<String> decodeListString(String encodedString){

    char[] characters = encodedString.toCharArray();
    StringBuilder stringbuilder = new StringBuilder();
    int position = 0;
    ArrayList<String> stringList = new ArrayList<String>();
    while(true){
        try {
        char character = characters[position];
        if(character == ','){
            String resultString = stringbuilder.toString();
            stringList.add(resultString);
            stringbuilder = new StringBuilder(); // clear it
        } else {
            stringbuilder.append(character);
        }

        position++;

        } catch (ArrayIndexOutOfBoundsException aiex){
            // List ended
            String resultString = stringbuilder.toString();
            if(!resultString.isEmpty())
                stringList.add(resultString);
            break;
        }

    }

    return stringList;

}