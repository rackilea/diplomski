public class PluginClass {

public static byte[] getIcon(PackageManager pm, ApplicationInfo applicationInfo) {
    try {
        BitmapDrawable icon = (BitmapDrawable) pm.getApplicationIcon(applicationInfo);
        Bitmap bmp = icon.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    } catch (Exception e) {
        return null;
    }
}

public static boolean isSystem(ApplicationInfo applicationInfo){
    return (applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM ) != 0;
   }
}
Then I have invoked it in Unity C# script:

void Start () {
    AndroidJavaClass jc = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
    AndroidJavaObject currentActivity = jc.GetStatic<AndroidJavaObject>("currentActivity");
    int flag = new AndroidJavaClass("android.content.pm.PackageManager").GetStatic<int>("GET_META_DATA");
    AndroidJavaObject pm = currentActivity.Call<AndroidJavaObject>("getPackageManager");
    AndroidJavaObject packages = pm.Call<AndroidJavaObject>("getInstalledApplications", 0);
    int count = packages.Call<int>("size");
    string[] names = new string[count];
    List<byte[]> byteimg = new List<byte[]>();
    int ii =0;
    for(int i=0; ii<count;){
        AndroidJavaObject currentObject = packages.Call<AndroidJavaObject>("get", ii );
        try{
            names[i] = pm.Call<string>("getApplicationLabel", currentObject);
            var plugin = new AndroidJavaClass("com.mypackagename.PluginClass");
            if(plugin.CallStatic<bool>("isSystem",currentObject)){
                ii++;
                continue;
            }
            byte[] decodedBytes = plugin.CallStatic<byte[]>("getIcon", pm, currentObject);
            Texture2D text = new Texture2D(1, 1, TextureFormat.ARGB32, false);
            text.LoadImage(decodedBytes);
            Sprite sprite = Sprite.Create (text, new Rect(0,0,text.width,text.height), new Vector2(.5f,.5f));
            i++;
            ii++;
        }
        catch(Exception e){
            Debug.LogError(e,this);
            ii++;
        }

    }