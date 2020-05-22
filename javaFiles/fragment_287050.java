@SharedPref(value = SharedPref.Scope.APPLICATION_DEFAULT)
public interface MyPreferences {
    @DefaultRes(R.bool.default_myOption)
    boolean myOption();

    @DefaultRes(R.string.default_myString)
    String myString();
}