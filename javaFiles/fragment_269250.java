@Module(subcomponents = {DIMarcaComponent.class})
public abstract class ViewBuilderModule {

    @Binds
    @IntoMap
    @FragmentKey(MarcaFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
        bindMarcaFragment(DIMarcaComponent.Builder bulder);
}