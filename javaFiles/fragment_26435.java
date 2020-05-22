public static String getDeviceId(Context paramContext) {
        String localObject = SharedPreferencesUtil.getCurrentDeviceId();
        if (localObject == null) {
            String str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
            if ((str1 == null) || (str1.trim().isEmpty()) || ("9774d56d682e549c".equalsIgnoreCase(str1)))
            {
                String str2 = Build.SERIAL;
                if ((str2 != null) && (!str2.trim().isEmpty())) {
                    str1 = Build.SERIAL;
                } else {
                    str1 = UUID.randomUUID().toString();
                }
            }
            if ("unknown".equals(str1))
            {
                String str3 = Build.SERIAL;
                if ((str3 != null) && (!str3.trim().isEmpty())) {
                    str1 = Build.SERIAL;
                } else {
                    str1 = UUID.randomUUID().toString();
                }
            }
            secondDeviceId = str1;