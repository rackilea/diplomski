Map<World, Integer> votes = new HashMap<>();

...

// Get list of entries and sort descending by value
List<Entry<World, Integer>> entries = new ArrayList<>( votes.entrySet() );
Collections.sort( entries, (e1,e2) -> -e1.getValue().compareTo( e2.getValue() ) );

// Collect top scoring worlds
List<World> topWorlds = new ArrayList<>();
int highScore = entries.get( 0 ).getValue();
for ( Entry<World,Integer> e : entries )
    if ( e.getValue() == highScore )
        topWorlds.add( e.getKey() );
    else
        break;

// Pick one at random
World pick = topWorlds.get( new Random().nextInt( topWorlds.size() ) );