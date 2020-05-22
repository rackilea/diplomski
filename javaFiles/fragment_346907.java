public static void switchToBranch(final String branchUrl,
    final File basedir,
    final ISVNDebugLog log) throws SVNException, IOException{
    final SVNUpdateClient updateClient =
        SVNClientManager
            .newInstance().getUpdateClient();
    if(log != null) updateClient.setDebugLog(log);
    updateClient.doSwitch(basedir,
        SVNURL.parseURIEncoded(branchUrl),
        SVNRevision.HEAD,
        SVNRevision.HEAD,
        SVNDepth.INFINITY,
        false,
        false);
}