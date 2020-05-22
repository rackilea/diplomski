@Module
public abstract class ThirdActivityModule {
    /**
     * Upcasts ThirdActivity to SecondActivity. SecondActivityModule will do
     * the rest to upcast it to Activity.
     */
    @Binds
    abstract SecondActivity bindActivity(ThirdActivity thirdActivity);
}