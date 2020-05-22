public static void displayWords(String line) {
    int i;
    for(i = 0; i < line.lengh(); i++) {
        if(line.charAt(i) = ' ')
            break;
    }
    System.out.println(line.substring(0, i);
    if(i < line.lengh())
        line = line.substring(i + 1, line.lengh();
    else
        line = "";
    if(line.lengh() > 0)
        displayWords(line);
}