@Database(
        entities = {
            Users.class,
            Passwords.class
        },
        version = VERSION
)
public abstract class MyRoomDb extends RoomDatabase {
...
}