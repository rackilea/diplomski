// Creating and registering the action 
IWorkbenchAction export = ActionFactory.EXPORT.create(window);
register(export);

 // adding it to standard file menu
fileMenu.add(export);