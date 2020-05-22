Repository repository = FileRepositoryBuilder.create(gitDir);
Git git = Git.wrap(repository);
FetchResult result = git.fetch().call();
for (TrackingRefUpdate refUpdate : result.getTrackingRefUpdates()) {
    // ...
}