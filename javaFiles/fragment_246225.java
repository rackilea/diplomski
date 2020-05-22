public static void main(String[] args) {
    String str1 = "drain";
    String str2 = "dane";
    String str3 = "main";
    String str4 = "vain";

    concat(str1, str2, str3, str4);

}
public static void concat(String s1, String s2, String s3, String s4) {

    String str;
    StringBuilder createdWord = new StringBuilder();

    for (int i = 0; i < s1.length(); i++) {
        char c = s1.charAt(i);
        if(createdWord.length() ==0) {
            createdWord.append(c);
        } else if (!createdWord.toString().contains(String.valueOf(c))){
            createdWord.append(c);
        }

    }

    for (int i = 0; i < s2.length(); i++) {
        char c = s2.charAt(i);
        if(createdWord.length() ==0) {
            createdWord.append(c);
        } else if (!createdWord.toString().contains(String.valueOf(c))){
            createdWord.append(c);
        }

    }

    for (int i = 0; i < s3.length(); i++) {
        char c = s3.charAt(i);
        if(createdWord.length() ==0) {
            createdWord.append(c);
        } else if (!createdWord.toString().contains(String.valueOf(c))){
            createdWord.append(c);
        }

    }

    for (int i = 0; i < s4.length(); i++) {
        char c = s4.charAt(i);
        if(createdWord.length() ==0) {
            createdWord.append(c);
        } else if (!createdWord.toString().contains(String.valueOf(c))){
            createdWord.append(c);
        }

    }


    str = createdWord.toString();
    System.out.println(str);

}