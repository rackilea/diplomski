public static void ordenaProfes(Profesor matrix[][]) {
  int n = matrix.length;
  boolean changed = true; //need to check, if something have changed
  while(changed){
      changed = false; //set changed to false at the begining
      int ix = 0;
      int jx = 0;
      double lastSalary= matrix[0][0].salary(); //
      for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              double aux= matrix[i][j].salary();
              if(aux  < lastSalary){
                  changed = true; //set change to true, so you know, that you have to iterate 1 more timr
                  //swap the element
                  Professor temp = matrix[ix][jx];
                  matrix[ix][jx] = matrix[i][j];
                  matrix[i][j] = temp;
              }
              //save the last element
              ix = i;
              jx = j;
              lastSalary = aux;
          }
      }
  }