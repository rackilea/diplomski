public static void main(String[] args) {
    int[] array3 = {0,1,3,2,3,0,3,1};
    int x = 3;
    int[] result = removeTwo(x, array3);
    for (int n : result) {
        System.out.print(""+ n + " ");
    }
}