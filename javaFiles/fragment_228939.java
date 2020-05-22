private int printArr(ArrayType a, int start, int rows) {
  rows = Math.min(rows, a.length - start);
  cnt1 = 0;
  for (int i = start; i < rows; i++) {
        for (int j = brds[i].start; j < brds[i].size + brds[i].start; j++) {
            System.out.printf(" {");
            System.out.printf("%6d ", a[j]);
            cnt1++; 
            System.out.printf("}");
            if(cnt1 == 10) {
                System.out.printf("\n");
                mod2++;
                cnt1=0;
            }
        }  
    }
    return start + rows; // current position 
}