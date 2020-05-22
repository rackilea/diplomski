public class UserProfile extends Model{


    //Fields from BasicProfile
    public String providerId;
    public String firstName;
    public String lastName;
    public String fullName;
    public String email;
    public String avatarUrl;

    String gender;
    Date dateOfBirth;
    //Define other custom fields

    //Your custom PasswordInfo model
    public PasswordInfo passwordInfo;

    public UserProfile(BasicProfile basicProfile) {

        this.providerId = basicProfile.providerId();
        // this.authUserId = Long.valueOf(profile.);
        if (basicProfile.firstName().isDefined())
            firstName = basicProfile.firstName().get();

        if (basicProfile.lastName().isDefined())
            lastName = basicProfile.lastName().get();
        if (basicProfile.fullName().isDefined())
            fullName = basicProfile.fullName().get();
        if (basicProfile.email().isDefined())
            email = basicProfile.email().get();
        if (basicProfile.avatarUrl().isDefined())
            avatarUrl = basicProfile.avatarUrl().get();
        if (basicProfile.passwordInfo().isDefined()) {
            String hasher = basicProfile.passwordInfo().get().hasher();
            String password = basicProfile.passwordInfo().get().password();
            String salt = basicProfile.passwordInfo().get().salt().isDefined() ? basicProfile.passwordInfo().get().salt().get()
                    : null;
            //Your own custom PasswordInfo model (not securesocial)
            passwordInfo = new PasswordInfo(hasher, password, salt, this);

        }

    }


    public BasicProfile getSecureSocialBasicProfile() {
        BasicProfile basicProfile = null;

        final scala.Option<securesocial.core.PasswordInfo> info = scala.Option.apply(
                new securesocial.core.PasswordInfo(passwordInfo.hasher, passwordInfo.password, scala.Option.apply(passwordInfo.salt)));

        basicProfile = new BasicProfile(providerId, id.toString(), scala.Option.apply(firstName),
                scala.Option.apply(lastName), scala.Option.apply(fullName), scala.Option.apply(email),
                scala.Option.apply(avatarUrl), AuthenticationMethod.UserPassword(), scala.Option.empty(),
                scala.Option.empty(), info);
        return basicProfile;

    }

    .....
    .....

}