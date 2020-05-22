Git git = new Git(gitRepository);

ObjectId newTreeId = ObjectId.fromString(commitSha + "^{tree}");
ObjectId oldTreeId = gitRepository.resolve(commitSha + "^^{tree}");

CanonicalTreeParser newTree = new CanonicalTreeParser();
newTree.reset(reader, newTreeId);

CanonicalTreeParser oldTree = new CanonicalTreeParser();
oldTree.reset(reader, oldTreeId);

for (DiffEntry de : git.diff().setNewTree(newTree).setOldTree(oldTree).call())
{
    /* Print the file diff */
    DiffFormatter formatter = new DiffFormatter(System.out);
    formatter.setRepository(gitRepository);
    formatter.format(de);
}