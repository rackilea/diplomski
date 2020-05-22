int[] inp = new int[]{1, 3, 3, 5};
int[][] sp = splitArrayByNum(inp, 3);
for(int i=0;i<sp.length;i++) {
    System.out.print(i + ": ");
    for(int j=0;j<sp[i].length;j++) {
        System.out.print(sp[i][j] + " ");
    }
    System.out.println();
}