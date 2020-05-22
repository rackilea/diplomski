@GinModules(AppClientModule.class)
public interface AppInjector extends Ginjector
{
    AppInjector INSTANCE = GWT.create(AppInjector.class);

    MainPanel getMainForm();
    TemplatePanel getTemplateForm();
}