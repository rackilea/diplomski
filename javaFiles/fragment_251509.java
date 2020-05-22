number = fin.nextInt();
    hits = fin.nextInt();
    walks = fin.nextInt();
    outs = fin.nextInt();
    // 6) find the index of this Player's numbEr

    index = findNumber(team, number, teamSize);
    // 7) if player number is not in the list
    if(index == -1 )
    ...