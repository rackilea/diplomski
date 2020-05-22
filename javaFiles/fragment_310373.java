@AScope
@Component(dependencies = ApplicationComponent.class,
           modules = ActivityModule.class)
interface ActivityComponent {
    void injectActivity(MainActivity activity);
    void injectFragment(ListFragment fragment);
    // Put any more injects here, if BaseFragment has
    // any other children that need to be injected, for example:
    void inject(MapFragment fragment);
    void inject(DetailFragment fragment);
}