ArrayList<Integer> blocklist = new ArrayList<Integer>();

        int blocked[][];

        blocklist.add(0);
        blocklist.add(4);
        blocklist.add(2);
        blocklist.add(2);
        blocklist.add(3);
        blocklist.add(1);
        blocklist.add(3);
        blocklist.add(3);



        blocked = new int[(blocklist.size()/2)][2];

        for (int i = -1, j = 0,k=0; k < blocklist.size(); j++) {
            blocked[j][0] = blocklist.get(++i);
            blocked[j][1] = blocklist.get(++i);
            k+=2;
        }

        for (int i = 0; i <(blocklist.size()/2);i++) {
            for (int j = 0; j < 2; ++j) {
                System.out.print(blocked[i][j]);
            }
        }

    System.out.println();
    String deepToString = Arrays.deepToString(blocked);
    System.out.println("string: "+deepToString);

output: 
04223133
string: [[0, 4], [2, 2], [3, 1], [3, 3]]