Result updateHead(
    Repository repo, String newHead, boolean force, boolean detach
) throws IOException {
    RefUpdate refUpdate = repo.getRefDatabase().newUpdate(Constants.HEAD, detach);
    refUpdate.setForceUpdate(force);
    return refUpdate.link(newHead);
}