public static void main(String[] args) {
    String testStr = "[23,22,17][17,2][23][3,29][][10,43,6][7][32,17,6][][][23,49,12][14,40,15][34,41,32][4,7,19][9,27][17][31,36,45][][32][40,27,25]";
    ArrayList<String[]> result = new ArrayList<>();
    String[] resTmp = testStr.split("\\[|\\]\\[");  // First split input into vectors

    for (String vecDef: resTmp)    // Then split each vector into a String[]
        result.add(vecDef.split(","));

    for (String[] s : result) {    // result = ArrayList with an element for each vector
        for (String ss : s)        // Each element is an array of Strings each being a number
            System.out.print(ss + " ");

        System.out.println();
    }
}