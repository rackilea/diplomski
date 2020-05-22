javaaddpath('/path/to/IgnoreModifiedKeystrokesAction.jar')
cmdwin = getCommandWindow();
editor = getEditor();

for t = [cmdwin,editor]
    defaultAction = t.getKeymap().getDefaultAction();
    if ~strcmp(defaultAction.class(),'IgnoreModifiedKeystrokesAction')
        newAction = IgnoreModifiedKeystrokesAction(defaultAction);
        t.getKeymap().setDefaultAction(newAction);
    end
end

%% Subfunctions to retrieve handles to the java text pane elements
function cw = getCommandWindow()
    try
        cw = handle(com.mathworks.mde.desk.MLDesktop.getInstance.getClient('Command Window').getComponent(0).getComponent(0).getComponent(0),'CallbackProperties');
        assert(strcmp(cw.class(),'javahandle_withcallbacks.com.mathworks.mde.cmdwin.XCmdWndView'));
    catch %#ok<CTCH>
        cw_client = com.mathworks.mde.desk.MLDesktop.getInstance.getClient('Command Window');
        cw = searchChildComponentsForClass(cw_client,'com.mathworks.mde.cmdwin.XCmdWndView');
    end
    if isempty(cw)
        error('Unable to find the Command Window');
    end
end

function ed = getEditor()
    try
        ed = handle(com.mathworks.mde.desk.MLDesktop.getInstance.getGroupContainer('Editor').getComponent(1).getComponent(0).getComponent(0).getComponent(0).getComponent(1).getComponent(0).getComponent(0).getComponent(0).getComponent(0).getComponent(1).getComponent(0).getComponent(0),'CallbackProperties');
        assert(strcmp(ed.class(),'javahandle_withcallbacks.com.mathworks.mde.editor.EditorSyntaxTextPane'));
    catch %#ok<CTCH>
        ed_group = com.mathworks.mde.desk.MLDesktop.getInstance.getGroupContainer('Editor');
        ed = searchChildComponentsForClass(ed_group,'com.mathworks.mde.editor.EditorSyntaxTextPane');
        % TODO: When in split pane mode, there are two editor panes. Do I need
        % to change actionMaps/inputMaps/Keymaps on both panes?
    end
    if isempty(ed)
        error('Unable to find the Editor Window');
    end
end

function obj = searchChildComponentsForClass(parent,classname)
    % Search Java parent object for a child component with the specified classname
    obj = [];
    if ~ismethod(parent,'getComponentCount') || ~ismethod(parent,'getComponent')
        return
    end
    for i=0:parent.getComponentCount()-1
        child = parent.getComponent(i);
        if strcmp(child.class(),classname)
            obj = child;
        else
            obj = searchChildComponentsForClass(child,classname);
        end
        if ~isempty(obj)
            obj = handle(obj,'CallbackProperties');
            break
        end
    end
end