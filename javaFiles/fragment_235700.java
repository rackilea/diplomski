List<AlgoritmeRecursive> tasks = new ArrayList<>();

for (Park p : parken) {
    if (p.getId() == startpark && eieren >= (oplossing[1000-(int)duur][1] - 5)) {

        AlgoritmeRecursive ar = new AlgoritmeRecursive(parken, afstandenTabel, oplossing, startpark, duur-1, eieren + gevonden, time+1);
        ar.fork();
        tasks.add(ar); // Adding the running task to the list.

    } else if (duur-afstandenTabel[startpark][p.getId()] > 60.0 && time > 120.0 && eieren >= oplossing[1000-(int)duur][1] && gevonden < p.verwachtAantalEieren(40,afstandenTabel[startpark][p.getId()])){

        AlgoritmeRecursive ar = new AlgoritmeRecursive(parken, afstandenTabel, oplossing, p.getId(), duur-afstandenTabel[startpark][p.getId()], eieren, 0);
        for (Park p2 : ar.parken) {
            p2.updateEggs(p2.getEggs() * exp((-1.0/10800.0) * (p2.getStartEggs()/20.0) * (afstandenTabel[startpark][p.getId()]-1)));
        }
        ar.fork();
        tasks.add(ar); // Adding the running task to the list.

    }
}

double score = eieren;
for(AlgoritmeRecursive task : tasks) {
    double res = ar.join();
    if(res > score) score = res;
}

return score;