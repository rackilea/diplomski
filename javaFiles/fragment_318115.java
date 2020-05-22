cmdwin = getCommandWindow();
editor = getEditor();

for t = [cmdwin,editor]
    defaultAction = t.getKeymap().getDefaultAction();
    if strcmp(defaultAction.class(),'IgnoreModifiedKeystrokesAction')
        oldAction = defaultAction.getOriginalAction();
        t.getKeymap().setDefaultAction(oldAction);
    end
end
javarmpath('/path/to/IgnoreModifiedKeystrokesAction.jar')