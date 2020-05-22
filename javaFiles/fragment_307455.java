@Singleton 
 @Component(modules = ApplicationModule.class)
 public interface ApplicationComponent {
     void inject(BaseActivity baseActivity);

     BaseNavigator navigator(); // changed to interface type
     Context context();
     //...
 }