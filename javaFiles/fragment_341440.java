Repository repo = new FileRepository(args[0]);
RevWalk walk = new RevWalk(repo);
RevCommit commit = walk.parseCommit(repo.resolve(args[1] + "^0"));
for (Map.Entry<String, Ref> e : repo.getAllRefs().entrySet())
  if (e.getKey().startsWith(Constants.R_HEADS))
    if (walk.isMergedInto(commit,
        walk.parseCommit(e.getValue().getObjectId())))
      System.out.println("Ref " + e.getValue().getName()
                                + " contains commit " + commit);