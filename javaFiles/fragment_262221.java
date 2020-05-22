public ArrayList<Player> ranking() {
    List<Player> result = new ArrayList<Player>();
    int smallInt = 0;
    int j=0;
    int smallIntIndex = 0;      

    for(int i=0;i<players.size() - 1;i++){
        smallInt = players.get(i).totalScore();
        smallIntIndex = i;
        for(j=i+1;j<players.size();j++){
            if(players.get(j).totalScore()<smallInt){
                smallInt = players.get(j).totalScore();
                smallIntIndex = j;                    
            }
        }

        if (i != smallIntIndex) {
            Player player = players.get(smallIntIndex);

            result.add(player);
            players.set(smallIntIndex, players.get(i));
        }
    }
    return result;
}