public class ProfileDefinitions {

    public static final String MY_ENABLED_PROFILE = "some-profile-enabled";

    // you can even make profiles derived from others:
    public static final String ACTIVE_WHEN_MY_IS_NOT = "!" + MY_ENABLED_PROFILE;
}