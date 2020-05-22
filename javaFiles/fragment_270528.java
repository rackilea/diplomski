Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
ActionManager actionManager = ActionManager.getInstance();
AnAction rearrangeAction = actionManager.getAction("RearrangeCode");
DataContext dataContext = DataManager.getInstance()
        .getDataContext(editor.getContentComponent());
Presentation presentation = rearrangeAction.getTemplatePresentation();
rearrangeAction.actionPerformed(
        AnActionEvent.createFromDataContext("", presentation, dataContext)
);