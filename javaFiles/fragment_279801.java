String url = "http://cvs-server.test.com:8001/svn/test";
SVNURL svnUrl = SVNURL.parseURIEncoded(url);
SVNRepository repos = SVNRepositoryFactory.create(svnUrl);
ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(DEFAULT_USER, DEFAULT_PASS);
repos.setAuthenticationManager(authManager); 
SVNNodeKind nodeKind = repos.checkPath("", repos.getLatestRevision());