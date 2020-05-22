public RevCommit gitFetch() throws Exception
{
    FetchResult result = git.fetch().setRemote("origin").call();
    System.out.println("Fetch : " + result.getURI().toString());
    return revWalk.parseCommit(result.getAdvertisedRef("refs/heads/" + localRepo.getBranch()).getTarget().getObjectId());
}