int v = 0;

for (int i = 0; i < arr.length; i++) {

for (int j = 0; j < arr[i].length; j++) {

        if (arr[i][j].charAt(0) == 'a') {
             v = i * arra.length +j;
             name2[v] = arr[i][j]; 
                count++;