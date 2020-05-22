@Component(modules={ApplicationModule.class})
@ApplicationScope
public class ApplicationComponent {
    Something something(); 
    AnotherThing anotherThing();

    void inject(Whatever whatever);
}

@Component(dependencies={ApplicationComponent.class}, modules={ActivityModule.class})
@ActivityScope
public interface ActivityComponent extends ApplicationComponent {
    ThirdThingy thirdThingy();

    void inject(SomeActivity someActivity);
}

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    //...
}

ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
ActivityComponent activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(SomeActivity.this)).build();