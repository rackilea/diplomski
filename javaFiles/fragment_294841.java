for (int i = 1; i <= 10; i++) {
            int triangular = 0;

            for (int j = 1; j <= i; j++) {
                triangular = triangular + j;
            }
            System.out.println(i + " = " + triangular);
       }