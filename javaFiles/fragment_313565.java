public static void main(String[] args) {
    StringBuilder sb = new StringBuilder(" a  + 5 v 5 + 6 + 7");
    String nieuw = trimOriginal(sb);
    System.out.println(nieuw);
    if (nieuw.matches("[^0-9+/*-]+")) {
        System.out.println(nieuw);

    } else {
        System.out.println("contains illegal charters");
    }
}

public static String trimOriginal(StringBuilder sb) {
    String buff = sb.toString();
    String[] split = buff.split("[0-9+/*-]+");
    StringBuilder b = new StringBuilder();
    for (String s : split) {
        b.append(s);
    }
    return b.toString().trim();
}