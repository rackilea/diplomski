public static void RunDummyActivity()
        {
            using (AndroidJavaClass unity_player = new AndroidJavaClass("com.unity3d.player.UnityPlayer"))
            {
                AndroidJavaObject current_activity = unity_player.GetStatic<AndroidJavaObject>("currentActivity");

                var jc = new AndroidJavaClass("com.exampleCompany.DummyActivity");
                jc.CallStatic("Launch", current_activity);
            }
        }