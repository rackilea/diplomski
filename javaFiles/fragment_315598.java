IViewPart part = pWindow.getActivePage().findView(pViewName);
pWindow.getActivePage().activate(part);
ActionFactory.IWorkbenchAction minimizeAction = ActionFactory.MINIMIZE.create(pWindow);
if (minimizeAction.isEnabled()) {
   minimizeAction.run();
}