@Component(modules={ApplicationModule.class})
@ApplicationScope
public interface ApplicationComponent {
    Something something();
    AnotherThing anotherThing();

    void inject(Whatever whatever);

    ActivityComponent newActivityComponent(ActivityModule activityModule); //subcomponent factory method
}

@Subcomponent(modules={ActivityModule.class})
@ActivityScope
public interface ActivityComponent {
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
ActivityComponent activityComponent = applicationComponent.newActivityComponent(new ActivityModule(SomeActivity.this));