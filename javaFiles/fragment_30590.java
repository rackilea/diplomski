DiffFormatter formatter = new DiffFormatter( System.out );
formatter.setRepository( git.getRepository() );
AbstractTreeIterator commitTreeIterator = prepareTreeParser( git.getRepository(),  Constants.HEAD );
FileTreeIterator workTreeIterator = new FileTreeIterator( git.getRepository() );
List<DiffEntry> diffEntries = formatter.scan( commitTreeIterator, workTreeIterator );

for( DiffEntry entry : diffEntries ) {
  System.out.println( "Entry: " + entry + ", from: " + entry.getOldId() + ", to: " + entry.getNewId() );
  formatter.format( entry );
}