// get a reference to the class
  AndroidJavaClass unity = new AndroidJavaClass ("com.unity3d.player.UnityPlayer");

  // get a reference to the class instance from a static variable
  AndroidJavaObject currentActivity = unity.GetStatic<AndroidJavaObject> ("currentActivity");

  // call a method in your UnityPlayer class that returns a string
  String s = currentActivity.Call<string>("myJavaMethodReturningString");