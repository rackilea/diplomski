@Component(modules = AModule.class)
@Singleton
public interface AComponent {
   void inject(...);

   SharedPreferences exposeSharedPreferences();
}