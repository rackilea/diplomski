void winner_information() {
    int winner=0;
    for(int i=0; i<list.size(); i++) {
        horse_info temp = list.get(i);
        if(calculateProficiency(temp) > calculateProficiency(list.get(winner))
            winner = i
    }
    //Print your winner horse (i) info
}
double calculateProficiency(horse_info h) {
    return (h.returnSpeed() * 0.3) + (h.returnSkill() * 0.2);
}