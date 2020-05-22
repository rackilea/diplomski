public String rovarSpraket(String normalString) {

    final String consonantsx = "bBcCdDeEfFgGhHjJkKlLmMnNpPqQrRsStTvVwWxXzZ"; 
    char consonants[] = consonantsx.toCharArray(); // String to charr

    int length = normalString.length(); // Length inc. space
    char array[] = normalString.toCharArray(); // Input to a char array

    String slang = "";
    System.out.println("På rövarspråk:");
    for (int i = 0; i < length; i++) {
        for (int x = 0; x < 20; x++) {
            if (array[i] == consonants[x]) {
                String add = array[i] + "o" + array[i];
                slang = slang + add;
                break;
            } else {
            }
        }
    }
    return slang;
}