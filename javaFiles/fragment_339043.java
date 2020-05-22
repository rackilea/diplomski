String[][] array = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}};
for(int i = 0; i < array[0].length; i++) {
    for(int j = 0; j < array.length; j++) {
        System.out.print(array[j][i]);
    }
    System.out.println();
}