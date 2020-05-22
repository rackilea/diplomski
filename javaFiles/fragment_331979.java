ISharingManager sharingManager = FileSystemCore.getSharingManager();
File workspaceRoot = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile();                               
PathLocation pathlocation = new PathLocation(workspaceRoot.getAbsolutePath());
ILocation sandBoxLocation = pathlocation.getCanonicalForm();
ISandbox sandbox = sharingManager.getSandbox(sandBoxLocation, false);
LoadDilemmaHandler p = LoadDilemmaHandler.getDefault();

monitor.subTask("searching for load rules file");

File f = LoadRuleUtility.createLoadRules(componentList);
InputStream ins = new FileInputStream(f);
Reader xmlReader = new InputStreamReader(ins);
ILoadRule2 rule = ILoadRuleFactory.loadRuleFactory.getLoadRule(con, xmlReader, monitor);                                    
ILoadOperation loadoperator = rule.getLoadOp(sandbox, p, monitor);
monitor.subTask("loading files from RTC server...");
loadoperator.run(monitor);