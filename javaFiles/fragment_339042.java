String[][] array = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k"}};

int maxColCount = 0;
int i = -1;
do {
    i++;
    for(int j = 0; j < array.length; j++) {
       if (array[j].length > i) {
          System.out.print(array[j][i]);
       }
       if (array[j].length > maxColCount) {
          maxColCount = array[j].length;
       }
    }
    System.out.println();
} while (i < maxColCount);