RevWalk walk = new RevWalk( repo );
walk.markStart( walk.parseCommit( repo.resolve( Constants.HEAD ) ) );
walk.sort( RevSort.REVERSE ); // chronological order
walk.setRevFilter( myFilter );
for( RevCommit commit : walk ) {
  // print commit
}
walk.close();