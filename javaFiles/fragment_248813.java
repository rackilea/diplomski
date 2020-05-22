class BingoPlayer implements Comparable<BingoPlayer> {

    // rest of your class
    String firstName, lastName;

    @Override
    public int compareTo(BingoPlayer player) {
        if(firstName.compareTo(player.firstName) != 0)
            return firstName.compareTo((player.firstName));
        else if (lastName.compareTo(player.lastName) != 0)
            return lastName.compareTo((player.lastName));
        else
            return lastName.compareTo(player.lastName);
    }
}