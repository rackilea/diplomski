@Module
    public interface ApplicationBindingModule {

/* These two lines, actually, makes Dagger generates ApplicationBindingModule_MainActivity class */
        @ContributesAndroidInjector
        MainActivity mainActivity();
    }