public class YourSwingApp extends SingleFrameApplication {
/**
 * At startup clean the DB.
 */
@Override
protected void startup() {
    show(new YourSwingApp(this));
    // issue a set of 'truncate table' or 'delete from table' query here
    // you may want to create a Singleton to centralize the DB operation
}
}