String team, team2;
do{
    team = al.get(showRandomInteger(0, 19, r));
}while(used.contains(team));

do{
    team2 = al.get(showRandomInteger(0, 19, r));
}while(used.contains(team2) || team2.equals(team1));