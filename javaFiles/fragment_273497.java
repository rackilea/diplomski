int numOfMonsters = monster.size();
Object data1[][] = new Object[numOfMonsters][5];
for(int i = 0; i < numOfMonsters; i++){
    data1[i][0] == icon.get(i);
    data1[i][1] == monster.get(i).getName();
    data1[i][2] == monster.get(i).getAp();
    data1[i][3] == monster.get(i).getHp();
    data1[i][4] == monster.get(i).getDp();    
}