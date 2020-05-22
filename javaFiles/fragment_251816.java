public List<RevCommit> between(String start, String end) throws Exception {
    RevWalk walk = new RevWalk(getRepository());
    RevCommit beginCommit = walk.parseCommit(getRepository().resolve(start));
    RevCommit endCommit = walk.parseCommit(getRepository().resolve(end));
    walk.close();
    return commitsBetween(beginCommit, endCommit);
}

private List<RevCommit> commitsBetween(RevCommit begin, RevCommit end) throws Exception {
    List<RevCommit> commits = new LinkedList<>();
    RevWalk walk = new RevWalk(getRepository());
    RevCommit parent = walk.parseCommit(end.getParent(0).getId());

    if (parent.getName().equals(begin.getName())) {
        commits.add(end);
        walk.close();
        return commits;
    } else {
        commits.add(end);
        commits.addAll(commitsBetween(begin, parent));
        walk.close();
        return commits;
    }
}