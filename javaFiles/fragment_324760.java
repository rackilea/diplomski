RevCommit youngestCommit = null;
Git git = new Git(repository);
List<Ref> branches = git.branchList().setListMode(ListMode.ALL).call();
try {
    RevWalk walk = new RevWalk(git.getRepository());
    for(Ref branch : branches) {
        RevCommit commit = walk.parseCommit(branch.getObjectId());
        if(youngestCommit == null || commit.getAuthorIdent().getWhen().compareTo(
           youngestCommit.getAuthorIdent().getWhen()) > 0)
           youngestCommit = commit;
    }
} catch (...)