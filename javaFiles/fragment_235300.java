TreeWalk tw = new TreeWalk(repository);
tw.setRecursive(true);
tw.addTree(CommitUtils.getHead(repository).getTree());
tw.addTree(new FileTreeIterator(repository));

RenameDetector rd = new RenameDetector(repository);
rd.addAll(DiffEntry.scan(tw));

List<DiffEntry> lde = rd.compute(tw.getObjectReader(), null);
for (DiffEntry de : lde) {
    if (de.getScore() >= rd.getRenameScore()) {
        System.out.println("file: " + de.getOldPath() + " copied/moved to: " + de.getNewPath());
    }
}