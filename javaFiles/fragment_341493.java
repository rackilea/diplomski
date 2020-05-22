class comparePlayer implements Comparator<Player>{

    public int compare(Player a, Player b) {
        if (a.getScore() < b.getScore()){
            return -1;
        }
        else if (a.getScore() == b.getScore()){
            return 0;
        }
        else{
            return 1;
        }
    }

}