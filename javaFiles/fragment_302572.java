public static ArrayList<String> fix(ArrayList<String> list) {
    ArrayList<String> temp = new ArrayList<>();
    for (Iterator<String> i = list.iterator(); i.hasNext();) {
        String str = i.next();
        boolean isL = str.contains("l");
        boolean isR = str.contains("r");

        if (isR ^ isL) {
            if (isR) {
                i.remove();
            }
            else {
                temp.add(str);
                temp.add(str);
            }
        }
        else {
            temp.add(str);
        }
    }
    return temp;
}