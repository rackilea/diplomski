for (i = 0; i < N; i++) { // **** you use "i" it here
     for (j = 0; j < N; j++) { // **** and "j" here
        if (Grid[i][j] == 0) {

           ArrayList<Integer> possible = create();

           for (i = 0; i < N; i++) { // **** and again here
              for (j = 0; j < N; j++) { // **** and again here
                 if (Grid[i][0] == possible.get(i)) {
                    possible.set(i, 0);
                 }
              }
           }

           for (i = 0; i < N; i++) { // **** and again here
              for (j = 0; j < N; j++) { // **** and again here
                 if (Grid[0][j] == possible.get(i)) {
                    possible.set(i, 0);
                 }
              }
           }

           // ....

           Grid[i][j] = value;
        }
     }
  }