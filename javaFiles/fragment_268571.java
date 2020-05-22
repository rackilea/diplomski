@Parcel(implementations = { UserRealmProxy.class },
        value = Parcel.Serialization.BEAN,
        analyze = { User.class })
public class User extends RealmObject {
    // ...
}

compile "org.parceler:parceler-api:1.0.3"
apt "org.parceler:parceler:1.0.3"