public void commit_logs() throws IOException, NoHeadException, GitAPIException {
    List<String> logMessages = new ArrayList<String>();
    FileRepositoryBuilder builder = new FileRepositoryBuilder();
    Repository repo = builder.setGitDir(new File("/path/to/repo" + "/.git"))
            .setMustExist(true).build();
    git = new Git(repo);
    Iterable<RevCommit> log = git.log().call();
    RevCommit previousCommit = null;
    for (RevCommit commit : log) {
        if (previousCommit != null) {
            AbstractTreeIterator oldTreeIterator = getCanonicalTreeParser( previousCommit );
            AbstractTreeIterator newTreeIterator = getCanonicalTreeParser( commit );
            OutputStream outputStream = new ByteArrayOutputStream();
            try( DiffFormatter formatter = new DiffFormatter( outputStream ) ) {
              formatter.setRepository( git.getRepository() );
              formatter.format( oldTreeIterator, newTreeIterator );
            }
            String diff = outputStream.toString();
            System.out.println(diff);
        }
        System.out.println("LogCommit: " + commit);
        String logMessage = commit.getFullMessage();
        System.out.println("LogMessage: " + logMessage);
        logMessages.add(logMessage.trim());
        previousCommit = commit;
    }
    git.close();
}


  private AbstractTreeIterator getCanonicalTreeParser( ObjectId commitId ) throws IOException {
    try( RevWalk walk = new RevWalk( git.getRepository() ) ) {
      RevCommit commit = walk.parseCommit( commitId );
      ObjectId treeId = commit.getTree().getId();
      try( ObjectReader reader = git.getRepository().newObjectReader() ) {
        return new CanonicalTreeParser( null, reader, treeId );
      }
    }
  }