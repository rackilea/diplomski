@PerActivity
@Component(modules = ActivityModule.class, dependencies = {UrlComponent.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}