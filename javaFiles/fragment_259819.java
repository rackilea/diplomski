Set<String> cases = new HashSet<String>();
  cases.add( TAG_PLAY.toLowerCase() );
  cases.add( TAG_PASSWORD.toLowerCase() );

  ...
  if ( cases.contains( e.getActionCommand().toLowerCase() ) { 
  ...