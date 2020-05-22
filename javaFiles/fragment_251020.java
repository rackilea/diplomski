/**
 * @param C the type of the Cursor this adapter returns
 */
public abstract class DatabaseAdapter<C> {
    protected abstract C executeQuery(String command);      
}