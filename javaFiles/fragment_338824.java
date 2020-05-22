@ActivityScope
@Subcomponent(
    modules = {
            LoginModule.class,
    }
)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}