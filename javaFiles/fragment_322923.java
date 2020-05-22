Map<Integer, Class<? extends Processor>> map = new HashMap<>();
// Integer.valueOf(x) used to prevent autoboxin just a matter of opinion.
map.put( Integer.valueOf( 0 ), MyProcessor.class );

Processor chosen = map.get( userIn ).getConstructor( String.class ).newInstance( projectKey );

launcher.addProcessor(chosen);