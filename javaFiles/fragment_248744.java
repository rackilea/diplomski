IWorkbenchPart part = HandlerUtil.getActivePart(event);

if (part instanceof NewView) {
   NewView newView = (NewView)part;

   ... call a method you define on NewView to access your 'bean' 
}