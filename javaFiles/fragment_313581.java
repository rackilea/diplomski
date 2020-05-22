for (int i = 1; i < field_h-2; i++) {
        for (int j = 1; j < field_w-2; j++) {
            if (user_field[i][j]==null) {
                user_field[i][j]=".";
            }
            if(field[i][j]==0) {
                for(int k = 0; k< 3; k++) {
                    for (int n = 0; n< 3; n++) {
                        user_field[i-1+k][j-1+n] = String.valueOf(field[i-1+k][j-1+n]);
                        //System.out.print(String.valueOf(field[i-1+k][j-1+n]));
                    }
                }
            }
        }
    }

   for (int i = 1; i < field_h-2; i++) {
        for (int j = 1; j < field_w-2; j++) {
            System.out.print(user_field[i][j]);
        }
        System.out.println(" "+ (i));
    }