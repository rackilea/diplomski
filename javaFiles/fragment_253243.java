String wpath = "/tmp/test-git";
    ArrayList<String> commits = new ArrayList<String>();

    // get list of commit
    {
        File gitDir = new File(wpath);
        RepositoryBuilder builder = new RepositoryBuilder();
        Repository repository = builder.setWorkTree(gitDir)
                .readEnvironment().findGitDir().build();
        Git git = new Git(repository);

        for (RevCommit commit : git.log().call()) {
            String cid = commit.getId().toString().split(" ")[1];
            commits.add(cid);
        }
        Collections.shuffle(commits);
    }

    // Random access
    {
        File gitDir = new File(wpath + "/subdir");
        RepositoryBuilder builder = new RepositoryBuilder();
        Repository repository = builder.setWorkTree(gitDir)
                .readEnvironment().findGitDir().build();

        for (String cid : commits) {
            RevCommit commit = CommitUtils.getCommit(repository, cid);
            assertEquals(commit.getId().toString().split(" ")[1], cid);
        }
    }