SVNURL svnurl = SVNURL.parseURIDecoded(url);
SVNRepository repository = SVNRepositoryFactory.create(svnurl);
ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(uname, password);
repository.setAuthenticationManager(authManager);
SVNClientManager ourClientManager = SVNClientManager.newInstance();
ourClientManager.setAuthenticationManager(authManager);
SVNUpdateClient updateClient = ourClientManager.getUpdateClient();
updateClient.setIgnoreExternals(true);

long latestRevision = repository.getLatestRevision();
if (updateClient.doCheckout(svnurl, destinationDir,
        SVNRevision.HEAD, SVNRevision.HEAD, SVNDepth.INFINITY,
                allowUnversionedObstructions) == latestRevision) {
    ourClientManager.dispose();
}