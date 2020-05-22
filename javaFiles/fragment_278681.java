public double votes() {
    long votexp = 0;
    for (Elettore e : docenti.values())
        if (e.getVoto())          //everytime this is true increment by 1
            votexp += 10;
    for (Elettore e : studenti.values())
        if (e.getVoto())         //everytime this is true increment by 0.2
            votexp += 2;
    for (Elettore e : pta.values())
        if (e.getVoto())        //everytime this is true increment by 0.2
            votexp += 2;
    return votexp / 10.0;
}