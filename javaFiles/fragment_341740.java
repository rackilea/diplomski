public class YourApp extends Application {

private static boolean mFirstRun = false;

public static boolean getFirstRun() { return mFirstRun; }
public static void clearFirstRun() { mFirstRun = false; }