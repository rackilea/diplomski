@Component(modules = {
  AndroidSupportInjectionModule.class,
  AppModule.class,
  ActivitiesModule.class,
  ServicesModule.class
})
public interface AppComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    Builder application(App application);

    AppComponent build();
  }

  void inject(App app);
}