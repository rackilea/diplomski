boolean done = false;
    for (int i=0;i<m && !done;i++){
        for (int j=0;j<n && !done;j++){
            Puzzle[i][j]= input.next();
            if (Puzzle[i][j] == null)
                done = true;
            System.out.println(Puzzle[i][j]);
        }
    }