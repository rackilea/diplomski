for(int z = 0; z < test3[y].length; z++){
        test3[y][z] = z;

        int B = test3[y][z];
        int C = test3[z][y];

        System.out.println(B + "/" + C);
    }