try (RevWalk walk = new RevWalk(repo)) {
  walk.markStart(walk.parseCommit(repo.resolve(Constants.HEAD)));
  walk.sort(RevSort.COMMIT_TIME_DESC);
  walk.setRevFilter(myFilter);
  for (RevCommit commit : walk) {
    if (commit.getCommitter().getWhen().equals(date)) {
      // this is the commit you are looking for
      revWalk.parseCommit(commit);
      break;
    }
  }
}