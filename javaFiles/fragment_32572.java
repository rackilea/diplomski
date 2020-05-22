InteractiveHandler handler = new InteractiveHandler() {
    public void prepareSteps(List<RebaseTodoLine> steps) {
        // loop through steps and use setAction to change action
    }

    public String modifyCommitMessage(String oldMessage) {
        return oldMessage;
    }
};

Repository repo = FileRepositoryBuilder.create(gitDir);
Git git = Git.wrap(repo);
git.rebase().setUpstream(commitA).runInteractively(handler).call();