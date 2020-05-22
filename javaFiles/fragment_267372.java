public String fixString(String input) {
    int i = 1;
    String result = "";
    for(char s : input.toCharArray()) {
        result += s;
        if(i != 0 && i % 4 == 0) {
            result += " ";
            if(i % 20 == 0) {
                result += "\n";
            }
        }
        i++;
    }
    return result;
}