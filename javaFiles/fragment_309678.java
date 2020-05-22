public interface DbAccessLibrary  ..

public class AndroidDbAccessLibrary implements DbAccessLibrary  ..

public class DesktopDbAccessLibrary implements DbAccessLibrary  ..

DbAccessLibrary accessLibrary;
try {
    getClass().getClassLoader().loadClass("android.database.sqlite.SQLiteDatabase");
    accessLibrary = new AndroidDbAccessLibrary();
} catch (ClassNotFoundException ex) {
    accessLibrary = new DesktopDbAccessLibrary();
}