@Override
public IInformationControl doCreateInformationControl(Shell parent) {
    ToolBarManager tbm = new ToolBarManager(SWT.FLAT);

    DefaultInformationControl iControl = new DefaultInformationControl(parent, tbm);

    IAction action = new MyAction();
    tbm.add(action);

    tbm.update(true);

    return iControl;
}