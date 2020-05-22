public static void main(String[] args) {
    function(3, 1);
}

public static String function(int input, int level) {
    String tab = "";
    for (int i = 0; i < level - 1; i++) {
        tab += "\t";
    }
    System.out.println(tab + "This is the " + level + " recursive call. Input value: " + input);
    if (input == 1) {
        System.out.println(tab + "Output value: 1");
        return "1";
    }
    String output = function(input - 1, level + 1);
    System.out.println(tab + "This is again the " + level + " recursive call. Input value: " + input);
    System.out.println(tab + "Output value: " + output + " + 1");
    return output + " + 1";
}