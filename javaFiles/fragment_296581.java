int res1 = -1, res2 = -1;

int maxDiff = Integer.MAX_VALUE;
for ( int i = 0; i < players.size( ); i++ )
{
    for ( int j = i + 1; j < players.size() ; j++ )
    {
        int diff = Math.abs( players.get(i).getPoints( ) - players.get(j).getPoints( ) );
        if ( diff < maxDiff )
        {
            maxDiff = diff;
            res1 = i;
            res2 = j;
        }           
    }
}
System.out.println(players.get(res1).getPlayerName( ) + " and " + players.get(res2).getPlayerName( ));