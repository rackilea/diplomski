private ILaunchConfigurationDialog fLaunchConfigurationDialog;

private final TestNGMainTab testngLaunchTab;

private Button runInUIThread;

/**
 * Constructor to create a new junit test tab
 */
public TestTab() {

    this.testngLaunchTab = new TestNGMainTab();
}

public void createControl(Composite parent) {
    testngLaunchTab.createControl(parent);

    Composite composite = (Composite) getControl();
createSpacer(composite);
    createRunInUIThreadGroup(composite);
}

private void createRunInUIThreadGroup(Composite comp) {
    runInUIThread = new Button(comp, SWT.CHECK);
    runInUIThread.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            updateLaunchConfigurationDialog();
        }
    });
    runInUIThread.setText(PDEUIMessages.PDEJUnitLaunchConfigurationTab_Run_Tests_In_UI_Thread);
    GridDataFactory.fillDefaults().span(2, 0).grab(true, false).applyTo(runInUIThread);
}

private void createSpacer(Composite comp) {
    Label label = new Label(comp, SWT.NONE);
    GridDataFactory.fillDefaults().span(3, 0).applyTo(label);
}

public void initializeFrom(ILaunchConfiguration config) {
    testngLaunchTab.initializeFrom(config);
    updateRunInUIThreadGroup(config);
}

private void updateRunInUIThreadGroup(ILaunchConfiguration config) {
    boolean shouldRunInUIThread = true;
    try {
        shouldRunInUIThread = config.getAttribute(IPDELauncherConstants.RUN_IN_UI_THREAD, true);
    } catch (CoreException ce) {
    }
    runInUIThread.setSelection(shouldRunInUIThread);
}

public void performApply(ILaunchConfigurationWorkingCopy config) {
    testngLaunchTab.performApply(config);
    boolean selection = runInUIThread.getSelection();
    config.setAttribute(IPDELauncherConstants.RUN_IN_UI_THREAD, selection);
}

@Override
public String getId() {
    return IPDELauncherConstants.TAB_TEST_ID;
}

@Override
public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
    testngLaunchTab.activated(workingCopy);
}

@Override
public boolean canSave() {
    return testngLaunchTab.canSave();
}

@Override
public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
    testngLaunchTab.deactivated(workingCopy);
}

@Override
public void dispose() {
    testngLaunchTab.dispose();
}

@Override
public String getErrorMessage() {
    return testngLaunchTab.getErrorMessage();
}

@Override
public Image getImage() {
    return testngLaunchTab.getImage();
}

@Override
public String getMessage() {
    return testngLaunchTab.getMessage();
}

public String getName() {
    return testngLaunchTab.getName();
}

@Override
public boolean isValid(ILaunchConfiguration config) {
    return testngLaunchTab.isValid(config);
}

public void setDefaults(ILaunchConfigurationWorkingCopy config) {
    testngLaunchTab.setDefaults(config);
}

@Override
public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {
    testngLaunchTab.setLaunchConfigurationDialog(dialog);
    this.fLaunchConfigurationDialog = dialog;
}