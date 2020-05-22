public class SearchBar {

NotificationManager nm;
public static String PACKAGE_NAME;
Context context;
 public  SearchBar(Context context) {
    this.context=context;
    PACKAGE_NAME = context.getPackageName();
}
....