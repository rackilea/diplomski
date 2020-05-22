public class Sample extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Put the package name here...
        boolean installed = appInstalledOrNot("com.Ch.Example.pack");  
        if(installed) {
            //This intent will help you to launch if the package is already installed
            Intent LaunchIntent = getPackageManager()
                .getLaunchIntentForPackage("com.Ch.Example.pack");
            startActivity(LaunchIntent);

            System.out.println("App is already installed on your phone");         
        } else {
            System.out.println("App is not currently installed on your phone");
        }
    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }

}