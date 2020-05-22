private static void printRow(int width, int level) {
    StringBuilder sb = new StringBuilder();
    if (width < 1) return;

    for (int i = 0; i < level; i++) {
        sb.append(" ");
    }

    for (int i = 0; i < width; i++) {
        if (i == 0 || i == width - 1) {
            sb.append("X");
        }
        else {
            sb.append(" ");
        }
    }
    System.out.println(sb.toString());
}