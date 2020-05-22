@Module
public class Validator {

    private final Activity activity;

    public Validator(Activity activity) {
        this.activity = activity;
    }

    @Provides
    com.mobsandgeeks.saripaar.Validator providesValidator() {
        return new com.mobsandgeeks.saripaar.Validator(activity);
    }
}