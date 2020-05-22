private Git git;
private Repository repo;

private void diffCommit(String hashID) throws IOException {
    //Initialize repositories.
    FileRepositoryBuilder builder = new FileRepositoryBuilder();
    repo = builder.setGitDir(new File("/path/to/repo" + "/.git")).setMustExist(true)
            .build();
    git = new Git(repo);

    //Get the commit you are looking for.
    RevCommit newCommit;
    try (RevWalk walk = new RevWalk(repo)) {
        newCommit = walk.parseCommit(repo.resolve(hashID));
    }

    System.out.println("LogCommit: " + newCommit);
    String logMessage = newCommit.getFullMessage();
    System.out.println("LogMessage: " + logMessage);
    //Print diff of the commit with the previous one.
    System.out.println(getDiffOfCommit(newCommit));

}
//Helper gets the diff as a string.
private String getDiffOfCommit(RevCommit newCommit) throws IOException {

    //Get commit that is previous to the current one.
    RevCommit oldCommit = getPrevHash(newCommit);
    if(oldCommit == null){
        return "Start of repo";
    }
    //Use treeIterator to diff.
    AbstractTreeIterator oldTreeIterator = getCanonicalTreeParser(oldCommit);
    AbstractTreeIterator newTreeIterator = getCanonicalTreeParser(newCommit);
    OutputStream outputStream = new ByteArrayOutputStream();
    try (DiffFormatter formatter = new DiffFormatter(outputStream)) {
        formatter.setRepository(git.getRepository());
        formatter.format(oldTreeIterator, newTreeIterator);
    }
    String diff = outputStream.toString();
    return diff;
}
//Helper function to get the previous commit.
public RevCommit getPrevHash(RevCommit commit)  throws  IOException {

    try (RevWalk walk = new RevWalk(repo)) {
        // Starting point
        walk.markStart(commit);
        int count = 0;
        for (RevCommit rev : walk) {
            // got the previous commit.
            if (count == 1) {
                return rev;
            }
            count++;
        }
        walk.dispose();
    }
    //Reached end and no previous commits.
    return null;
}
//Helper function to get the tree of the changes in a commit. Written by Rüdiger Herrmann
private AbstractTreeIterator getCanonicalTreeParser(ObjectId commitId) throws IOException {
    try (RevWalk walk = new RevWalk(git.getRepository())) {
        RevCommit commit = walk.parseCommit(commitId);
        ObjectId treeId = commit.getTree().getId();
        try (ObjectReader reader = git.getRepository().newObjectReader()) {
            return new CanonicalTreeParser(null, reader, treeId);
        }
    }
}