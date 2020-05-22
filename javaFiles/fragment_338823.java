@ActivityScope
@Subcomponent(
    modules = {
            MainModule.class,
    }
)
public interface MainComponent {

    void inject(MainActivity mainActivity);

}