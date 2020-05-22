@Singleton
@Component(modules = {AppModule.class})
interface AppComponent {
  @ApplicationContext
  Context getContext();
}