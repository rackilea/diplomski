git.commit().setMessage("tagged").call();
git.tag().setName("mytag").call();
git.commit().setMessage("untagged").call();

Iterable<RevCommit> commits = git.log().call();
for (RevCommit commit : commits) {
  Map<ObjectId, String> namedCommits = git.nameRev().addPrefix("refs/tags/").add(commit).call();
  if (namedCommits.containsKey(commit.getId())) {
    System.out.println("tag " + namedCommits.get(commit.getId()) + " -> " + commit);
  }
}