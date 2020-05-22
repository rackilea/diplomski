RevFilter filter = new RevFilter() {
  @Override
  public boolean include( RevWalk walker, RevCommit commit )
    throws StopWalkException, IOException
  {
    return commit.getAuthorIdent().getName().equals( "author" );
  }

  @Override
  public RevFilter clone() {
    return this; // may return this, or a copy if filter is not immutable
  }
};