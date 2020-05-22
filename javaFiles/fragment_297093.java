@Component(modules={ApplicationModule.class})
@ApplicationScope
public interface ApplicationComponent {
    Something something();
    AnotherThing anotherThing();

    void inject(Whatever whatever);
}

@Module
public class ApplicationModule {
    @ApplicationScope //application-scoped provider, only one can exist per component
    @Provides
    public Something something() {
         return new Something();
    }

    @Provides //unscoped, each INJECT call creates a new instance
    public AnotherThing anotherThing() {
        return new AnotherThing();
    }
}