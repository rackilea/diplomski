public int[][] doldur() { // ========> fill method
for (int i = 0; i < dizi.length; i++) {
    for (int j = 0; dizi[i] != null && j < dizi[i].length; j++) { 
      //               ^                         ^
      //           not null                   dizi[i].length 
      //                                         instead of
      //                                      dizi.length[i]
      // Do domething

    }
}