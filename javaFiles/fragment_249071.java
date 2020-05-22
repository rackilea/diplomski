File file = new File( git.getRepository().getWorkTree(), "file.txt" );
writeFile( file, "first version" );
RevCommit newCommit = commitChanges();
writeFile( file, "second version" );
RevCommit oldCommit = commitChanges();

ObjectReader reader = git.getRepository().newObjectReader();
CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
ObjectId oldTree = git.getRepository().resolve( "HEAD^{tree}" ); // equals newCommit.getTree()
oldTreeIter.reset( reader, oldTree );
CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
ObjectId newTree = git.getRepository().resolve( "HEAD~1^{tree}" ); // equals oldCommit.getTree()
newTreeIter.reset( reader, newTree );

DiffFormatter df = new DiffFormatter( new ByteArrayOutputStream() ); // use NullOutputStream.INSTANCE if you don't need the diff output
df.setRepository( git.getRepository() );
List<DiffEntry> entries = df.scan( oldTreeIter, newTreeIter );

for( DiffEntry entry : entries ) {
  System.out.println( entry );
}

private RevCommit commitChanges() throws GitAPIException {
  git.add().addFilepattern( "." ).call();
  return git.commit().setMessage( "commit message" ).call();
}

private static void writeFile( File file, String content ) throws IOException {
  FileOutputStream outputStream = new FileOutputStream( file );
  outputStream.write( content.getBytes( "UTF-8" ) );
  outputStream.close();
}