@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class /* it makes Dagger generates DaggerNannyApplicationComponent */,
        ApplicationBindingModule.class /* it generats AndroidInjector.Builder<MainActivity>, which
        is used to inject requested dependencies by MainActivity */
})
public interface NannyApplicationComponent extends AndroidInjector<NannyApplication> {

    @Component.Builder /* Simply tells this Builder is DaggerNannyApplicationComponent’s inner Builder class */
    abstract class Builder extends AndroidInjector.Builder<NannyApplication> {
    }
}