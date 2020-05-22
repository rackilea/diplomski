Properties props = new Properties();
    props.setProperty("login", "somebody@somewhere.com");
    props.setProperty("password", "YourGithubPassword");

    GitHub gitHub = GitHubBuilder.fromProperties(props).build();

    GHRepository repository = gitHub.getRepository("your/repo");

    Calendar cal = Calendar.getInstance();
    cal.set(2014, 0, 4);
    Date since = cal.getTime();
    cal.set(2014, 0, 14);
    Date until = cal.getTime();

    GHCommitQueryBuilder queryBuilder = repository.queryCommits().since(since).until(until);
    PagedIterable<GHCommit> commits = queryBuilder.list();
    Iterator<GHCommit> iterator = commits.iterator();

    while (iterator.hasNext()) {
        GHCommit commit = iterator.next();
        System.out.println("Commit: " + commit.getSHA1() + ", info: " + commit.getCommitShortInfo().getMessage() + ", author: " + commit.getAuthor());
    }