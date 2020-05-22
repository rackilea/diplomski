private void pullWithRebase(Git git) throws GitAPIException {
    git.checkout().setName("master").call();
    List<Ref> branches = git.branchList().setListMode(ListBranchCommand.ListMode.ALL).call();
    String remoteMasterBranchName = "refs/remotes/origin/master";
    for (Ref ref : branches) {
        if (remoteMasterBranchName.equals(ref.getName())) {
            git.pull().setRemoteBranchName("master").setRebase(true).call();
            return;
        }
    }
}