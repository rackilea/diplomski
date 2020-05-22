String[][] array = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k"}};

for(int i = 0; i<array.length; i++) {
    for(int j = 0; j<array[i].length; j++) {
       System.out.print(array[j][i]);
    }
    System.out.println();
}