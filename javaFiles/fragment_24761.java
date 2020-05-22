String json = "{\"ad_native_enabled\": false}";
Settings settings = gson.fromJson(json, Settings.class);
System.out.println(settings.nativeAdEnabled.value);  // prints false
System.out.println(settings.nativeAdEnabled.isDefaultValue);  // prints false

String emptyJson = "{}";
Settings emptySettings = gson.fromJson(emptyJson, Settings.class);
System.out.println(emptySettings.nativeAdEnabled.value);  // prints false
System.out.println(emptySettings.nativeAdEnabled.isDefaultValue);  //prints true