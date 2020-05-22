abstract class AbstractCommandTest {
    abstract void execute();
    abstract void collectData();
    abstract void processData();
    abstract void setData(ArrayList<Objects> data);
    // Other methods shared by all commands
}
abstract class AbstractDatabaseCommandTest extends AbstractCommandTest {
    protected Database db;
    protected AbstractDatabaseCommandTest(Database db) {
        this.db = db;
    }
}
class SomeCommandThatDoesNotNeedDatabase extends AbstractCommandTest {
    ...
}
class DatabaseCommand1 extends AbstractDatabaseCommandTest {
    ...
}
class DatabaseCommand2 extends AbstractDatabaseCommandTest {
    ...
}