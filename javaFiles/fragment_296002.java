try (Git git = new Git(repository)) {
            Iterable<RevCommit> logs = git.log()
                    .not(repository.resolve("master"))
                    .add(repository.resolve("remotes/origin/testBranch"))
                    .call();
            count = 0;
            for (RevCommit rev : logs) {
                System.out.println("Commit: " + rev /* + ", name: " + rev.getName() + ", id: " + rev.getId().getName() */);
                count++;
            }
            System.out.println("Had " + count + " commits only on test-branch");
        }