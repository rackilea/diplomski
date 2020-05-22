public static String display(ArrayList<String> words) {
    String s = "";
    int index = 0;
    boolean hit = false;
    while (!hit) {
        for (int i = 0; i < words.size(); i++) {
            String w = words.get(i);
            if (w.length() > index) {
                s += w.charAt(index);
                hit = true;
            }
        }           
        if (hit) {
            hit = false;
            index++;
            s += " ";
        } else {
            hit = true;
        }

    }
    return s.trim();
}