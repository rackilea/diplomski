private static void printFloor(int width, char c) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < width; i++) {
        sb.append(c);
    }
    sb.append(" ");
    System.out.print(sb.toString());
}