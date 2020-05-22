public String gerRightFormat(String input) {
    String output = "";
    for (int i = 0; i < input.length(); i++) {
        if (i <= 4) {
            output += input.charAt(i);
        } else if (i >= 5 && i <= 6) {
            output += input.charAt(i);
        } else if (i >= 7 && i <= 9) {
            output += input.charAt(i);
        } else if (i >= 10 && i <= 12) {
            output += input.charAt(i);
        } else if (i >= 13 && i <= 15) {
            output += input.charAt(i);
        }
        if (i == 3) {
            output += "-";
        } else if (i == 5) {
            output += "T";
        } else if (i == 8) {
            output += ":";
        } else if (i == 11) {
            output += ":";
        }
    }
    return output;
}