String line = in.readLine();

 Char[][] e = new Char[3][5];

 for(int i = 0; i < e.length; i++) {
            for(int j = 0; j < e.length; j++) {
                e[i][j] = line.charAt(j);//to access element at jth index of string
            }
        }

        // print array
        for(int i = 0; i < e.length; i++) {
            for(int j = 0; j < e.length; j++) {
                System.out.print(e[i][j]);
            }
            System.out.println()
        }