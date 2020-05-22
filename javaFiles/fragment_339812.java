AndroidJavaClass unityClass;
AndroidJavaObject unityActivity;
AndroidJavaObject unityContext;
AndroidJavaClass customClass;

public string getCertificateSHA1Fingerprint()
{
    //Replace with your full package name
    string packageName = "com.example.CertificateSHA1Fingerprint";

    unityClass = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
    unityActivity = unityClass.GetStatic<AndroidJavaObject>("currentActivity");
    unityContext = unityActivity.Call<AndroidJavaObject>("getApplicationContext");

    customClass = new AndroidJavaClass(packageName);

    string result = customClass.CallStatic<string>("getCertificateSHA1Fingerprint", unityContext);
    return result;
}