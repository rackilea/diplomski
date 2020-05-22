public class TestNGPluginTabGroup extends
AbstractLaunchConfigurationTabGroup  {

    public TestNGPluginTabGroup() {
    }

    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {

        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {

                        new TestTab(),
                        new PluginTestNGMainTab(),
                        new JavaArgumentsTab(), 
                        new PluginsTab(false),
                        new JavaArgumentsTab(),
                        new PluginsTab(), 
                        new TracingTab(),
                        new ConfigurationTab(true), 
                        new TracingTab(), 
                        new EnvironmentTab(), 
                        new CommonTab()
        };

                setTabs(tabs);
                  }