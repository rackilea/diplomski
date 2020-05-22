@Singleton 
 @Component(modules = ApplicationModule.class)
 public interface ApplicationComponent {
     void inject(BaseActivity baseActivity);

     Navigator navigator();
     Context context();
     //...
 }