public void fill(int i) {
    if(i > 0) {
        int[][] part = new int[2][2];
        part[0][0] = i;
        result.add(part);
        i--;
        fill(i);
    }
}