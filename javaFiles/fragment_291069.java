int[][] ar = new int[][]
        {
        { 0, 1, 2 },
        { 3, 4, 5 },
        { 6, 7, 8 } };
    ArrayList<ArrayList<Integer>> a = new ArrayList<>(ar.length);
    ArrayList<Integer> blankLine = new ArrayList<>(ar.length * 2 - 1);
    for (int i = 0; i < ar.length * 2 - 1; i++)
    {
        blankLine.add(0);
    }

    for (int i = 0; i < ar.length; i++)
    {
        ArrayList<Integer> line = new ArrayList<>();
        for (int j = 0; j < ar[i].length; j++)
        {
            line.add(ar[i][j]);
            if (j != ar[i].length - 1)
                line.add(0);
        }
        a.add(line);
        if (i != ar.length - 1)
            a.add(blankLine);
    }

    for (ArrayList<Integer> b : a)
    {
        System.out.println(b);
    }