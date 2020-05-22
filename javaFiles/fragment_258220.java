public static void sendNotification() {
        Push push = new Push();
        push.setAliases(Arrays.asList("39901"));

        // For Android
        Android android = new Android();
        android.setAlert("hi there");
        push.setAndroid(android);

        // For iOS
        // APS aps = new APS();
        // aps.setBadge(1);
        // aps.setAlert("hi there");
        // aps.setSound("default");
        // aps.setData("additinoal data");
        // push.setAps(aps);

        UrbanAirshipClient uac = new UrbanAirshipClient("app key",
                "master app key");
        uac.sendPushNotifications(push);
    }