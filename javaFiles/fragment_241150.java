DAVRepositoryFactory.setup();
String url = "(directory in svn url)";
String name = "(login name)";
String password = "(login password)";
SVNRepository repository = null;
repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url));
ISVNAuthenticationManager authManager =
                   SVNWCUtil.createDefaultAuthenticationManager(name, password);
repository.setAuthenticationManager(authManager);
SVNDirEntry entry = repository.info(".", -1);
System.out.println("Latest Rev: " + entry.getRevision());