public static void main(String[] args) {
    String str = "67.9200";
    int n1 = 2;
    int n2 = 3;
    StringBuilder sb = new StringBuilder();

    for (int i = str.length() - 1; i >= 0; i--) {
        if (n2 > 0) {
            char c = str.charAt(i);
            sb.append(c);
            if (c != '.') {
                n2--;
                if (n2 == 0) {
                    sb.append(" ");
                }
            }
        } else if (n1 > 0) {
            char c = str.charAt(i);
            sb.append(c);
            if (c != '.') {
                n1--;
                if (n1 == 0) {
                    sb.append(" ");
                }
            }
        } else {
            sb.append(str.charAt(i));
        }
    }

    System.out.println(sb.reverse().toString());
}