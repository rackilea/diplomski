public static void main(String[] args) {

    String[] array1 = { "hello1", "A2", "X19912" };
    String[] array2 = { "hello2", "B2", "Y19912" };
    String[] array3 = { "hello3", "C2", "Z19912" };
    String[] copyArrays = new String[array1.length + array2.length
            + array3.length];
    System.arraycopy(array1, 0, copyArrays, 0, array1.length);
    System.arraycopy(array2, 0, copyArrays, array1.length, array2.length);
    System.arraycopy(array3, 0, copyArrays, array1.length + array2.length,
            array3.length);

    String[][] array = new String[3][3];
    int index = 0;
    for (int i = 0; i < array.length; i++)
        for (int j = 0; j < array[i].length; j++) {
            array[i][j] = copyArrays[index++];
        }

    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {

            System.out.print(array[i][j] + "  ");
        }
        System.out.println();
    }
}