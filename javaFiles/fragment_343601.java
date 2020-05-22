// setup the first repository to fetch from the second repository
final StoredConfig config = db.getConfig();
RemoteConfig remoteConfig = new RemoteConfig(config, "test");
URIish uri = new URIish(db2.getDirectory().toURI().toURL());
remoteConfig.addURI(uri);
remoteConfig.update(config);
config.save();

// create some refs via commits and tag
RevCommit commit = git2.commit().setMessage("initial commit").call();
Ref tagRef = git2.tag().setName("tag").call();

Git git1 = new Git(db);

RefSpec spec = new RefSpec("refs/heads/master:refs/heads/x");
git1.fetch().setRemote("test").setRefSpecs(spec)
.call();