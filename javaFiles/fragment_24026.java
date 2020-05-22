private static ArrayList<Player> getWinners(ArrayList<Player> players)
{
    ArrayList<Player> l = new ArrayList<Player>();
    int maxPoints = -1; //Assuming it is not possible to have negative points

    for (int i = 0; i < players.size(); i++)
    {
        int points = players.get(i).getPoints();
        if (points >= maxPoints) {
            if (points > maxPoints) {
                l.clear(); //Clear the return list, since a new "best score" was found
            }
            maxPoints = points;
            l.add(players.get(i));
        }
    }
    return l; 
}