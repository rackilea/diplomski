private AndroidJavaClass androidClass;
  private AndroidJavaObject androidFunction;

  #if UNITY_ANDROID
        if (androidClass == null || androidFunction == null)
        {
            androidClass = new AndroidJavaClass("com.roxy.app.Lib1");
            androidFunction = androidClass.GetStatic<AndroidJavaObject>("instance");
        }
  #endif