public ArrayList<Player> ranking() {
    List<Player> result = new ArrayList<Player>(players);
    int smallInt = 0;
    int j=0;
    int smallIntIndex = 0;      

    for(int i=0;i<result.size() - 1;i++){
        smallInt = result.get(i).totalScore();
        smallIntIndex = i;
        for(j=i+1;j<result.size();j++){
            if(result.get(j).totalScore()<smallInt){
                smallInt = result.get(j).totalScore();
                smallIntIndex = j;                    
            }
        }

        if (i != smallIntIndex) {
            Player temp = result.get(smallIntIndex);
            result.set(smallIntIndex, result.get(i));
            result.set(i, temp);
        }
    }
    return result;
}