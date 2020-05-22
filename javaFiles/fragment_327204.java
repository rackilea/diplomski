FileSystemManager manager = VFS.getManager();
FileObject file= manager.resolveFile("c:/MyFile.txt");

DefaultFileMonitor fm = new DefaultFileMonitor(new MyListener());
fm.setDelay(5000);
fm.addFile(file); 
fm.start();