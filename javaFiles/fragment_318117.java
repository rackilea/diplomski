public static void main(final String[] args){

    // example provided by Jason via Stackoverflow

    String message = "&*#$@?ebyam,&?siht&=asdf???od&failure???&?on?nac&the%%@?uoy&horizon!";

    System.out.println("#1: " + message.length());

    List<String> words = new ArrayList<String>();
    int questionPos = message.indexOf("?");
    while(questionPos > -1) {
        message = message.substring(questionPos + 1, message.length());

        int ampersandPos = message.indexOf("&");
        questionPos = message.indexOf("?");

        if(ampersandPos > 0 && (ampersandPos < questionPos || questionPos == -1)) {
            String word = message.substring(0, ampersandPos);
            StringBuilder reversedWord = new StringBuilder();
            for(int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }
            words.add(reversedWord.toString());
        }
    }

    System.out.println("#2: " + words.size());

    System.out.println("#3:");
    for(final String word : words) {
        System.out.println(word);
    }

    System.out.println("#4:");
    for(int i = words.size() - 1; i >= 0; i--) {
        System.out.println(words.get(i));
    }

    System.out.print("#5: ");
    for(int i = words.size() - 1; i >= 0; i--) {
        if(i < words.size() - 1) {
            System.out.print(" ");
        }
        System.out.print(words.get(i));
    }
}