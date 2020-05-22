public static void main(String[]args) {
    String phrase = "‫;‪14/May/2015‬‬ ‫‪FC‬‬ ‫‪Barcelona‬‬ ‫‪VS.‬‬ ‫‪Real‬‬ ‫‪Madrid";
    String[] dateSplit = phrase.split(";");
    for (String d : dateSplit) {
        System.out.println(d);
    }
    char[] c = phrase.toCharArray();
    StringBuilder p = new StringBuilder();
    for (int i = 0; i < c.length;i++) {
        int code = Character.codePointAt(c, i);
        switch (code) {
        case 8234:
            p.append(" -> ");
            break;
        case 8235:
            p.append(" <- ");
            break;
        case 8236:
            p.append(" ^ ");
            break;
        default:
            p.append(c[i]);
        }
    }
    System.out.println(p.toString());
}