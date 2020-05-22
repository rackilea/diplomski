Button btn;
Context context;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn=(Button)findViewById(R.id.btn);
    context=getApplicationContext();
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isAppInstalled()) {
                Toast.makeText(getApplicationContext(), "facebook app already installed", Toast.LENGTH_SHORT).show();
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(context);
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);

            } else {
                Toast.makeText(getApplicationContext(), "facebook app not installing", Toast.LENGTH_SHORT).show();
            }



        }
    });
}
public static String FACEBOOK_URL = "https://www.facebook.com/YourPageName";
public static String FACEBOOK_PAGE_ID = "YourPageName";

//method to get the right URL to use in the intent
public String getFacebookPageURL(Context context) {
    PackageManager packageManager = context.getPackageManager();
    try {
        int versionCode = packageManager.getPackageInfo("com.facebook.orca", 0).versionCode;
        if (versionCode >= 3002850) { //newer versions of fb app
            return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
        } else { //older versions of fb app
            return "fb://page/" + FACEBOOK_PAGE_ID;
        }
    } catch (PackageManager.NameNotFoundException e) {
        return FACEBOOK_URL; //normal web url
    }
}



public boolean isAppInstalled() {
    try {
        getApplicationContext().getPackageManager().getApplicationInfo("com.facebook.katana", 0);
        return true;
    } catch (PackageManager.NameNotFoundException e) {
        return false;
    }
}