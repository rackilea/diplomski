public TestNGProgramBlock(AbstractLauncherTab tab) {

    super(tab);
    }

public void setDefaults(ILaunchConfigurationWorkingCopy config) {

if (!LauncherUtils.requiresUI(config))
config.setAttribute(IPDELauncherConstants.APPLICATION, 
ITestNGPluginLauncherConstants.CORE_TEST_APPLICATION);

else
super.setDefaults(config);  
}

protected String[] getApplicationNames() {

TreeSet result = new TreeSet();
         result.add(ITestNGPluginLauncherConstants.TestNGProgramBlock_headless);
String[] appNames = super.getApplicationNames();        
for (int i = 0; i < appNames.length; i++) {
result.add(appNames[i]);
}
return appNames;
}
protected void initializeApplicationSection(ILaunchConfiguration config) 
throws CoreException {
String application = 
config.getAttribute(IPDELauncherConstants.APPLICATION, (String)null);
if(ITestNGPluginLauncherConstants.CORE_TEST_APPLICATION.
equals(application))

fApplicationCombo.setText(ITestNGPluginLauncherConstants.
TestNGProgramBlock_headless); 
else

super.initializeApplicationSection(config); 
}
protected void saveApplicationSection(ILaunchConfigurationWorkingCopy config)
{
if(fApplicationCombo.getText().equals(ITestNGPluginLauncherConstants.
TestNGPogramBlock_headless)){

String appName = fApplicationCombo.isEnabled() ? 

ITestNGPluginLauncherConstants.CORE_TEST_APPLICATION : null;    

config.setAttribute(IPDELauncherConstants.APPLICATION, appName);    

config.setAttribute(IPDELauncherConstants.APP_TO_TEST, (String)null);
}

}   
}