class BingoPlayerComparator implements Comparator<BingoPlayer> {

    @Override
    public int compare(BingoPlayer player1, BingoPlayer player2) {
        if(player1.firstName.compareTo(player2.firstName) != 0)
            return player1.firstName.compareTo((player2.firstName));
        else if (player1.lastName.compareTo(player2.lastName) != 0)
            return player1.lastName.compareTo((player2.lastName));
        else 
            return player1.lastName.compareTo(player2.lastName);
    }
}