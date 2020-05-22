@ApplicationScope
@Component(
    modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(Application application);

    MainComponent plus(MainModule mainModule);
    LoginComponent plus(LoginModule loginModule);

}