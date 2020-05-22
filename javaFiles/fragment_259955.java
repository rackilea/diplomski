public static double [][] removeRow(double [][] m , int n){ 
    double [][] finalm = new double [m.length-1][m[0].length];  

    for (int i = 0; i<finalm.length; i++) {                     
          if (i<n) {                                      
              finalm[i]=m[i];                       
          }
          if (i>=n) {                                     
              finalm[i]=m[i+1];                     
          }
    }
    return finalm;
}