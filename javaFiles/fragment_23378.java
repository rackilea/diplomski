ObjectReader reader = git.getRepository().newObjectReader();
CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
ObjectId oldTree = git.getRepository().resolve( "HEAD~1^{tree}" );
oldTreeIter.reset( reader, oldTree );
CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
ObjectId newTree = git.getRepository().resolve( "HEAD^{tree}" );
newTreeIter.reset( reader, newTree );

DiffFormatter diffFormatter = new DiffFormatter( DisabledOutputStream.INSTANCE );
diffFormatter.setRepository( git.getRepository() );
List<DiffEntry> entries = diffFormatter.scan( oldTreeIter, newTreeIter );

for( DiffEntry entry : entries ) {
  System.out.println( entry.getChangeType() );
}