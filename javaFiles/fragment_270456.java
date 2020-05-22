SVNRepository repository = SVNRepositoryFactory.create(url);       

ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(user,password);
repository.setAuthenticationManager(authManager);

ISVNEditor editor = repository.getCommitEditor("comment" , null);
editor.openRoot(-1);
editor.openFile("/file1.txt", -1);
editor.changeFileProperty("/file1.txt", "mypropertyname", SVNPropertyValue.create("myvalue"));
editor.closeFile("/file1.txt",null);
editor.closeEdit();