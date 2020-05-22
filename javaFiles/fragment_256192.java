private static AbstractTreeIterator prepareTreeParser(Repository repository, ObjectId objectId) throws IOException {
    // from the commit we can build the tree which allows us to construct the TreeParser
    //noinspection Duplicates
    try (RevWalk walk = new RevWalk(repository)) {
        RevCommit commit = walk.parseCommit(objectId);
        RevTree tree = walk.parseTree(commit.getTree().getId());
        CanonicalTreeParser treeParser = new CanonicalTreeParser();
        try (ObjectReader reader = repository.newObjectReader()) {
            treeParser.reset(reader, tree.getId());
        }
        walk.dispose();
        return treeParser;
    }
}