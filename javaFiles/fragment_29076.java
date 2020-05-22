-injars  android-sdk/extras/google/google_play_services/libproject/google-play-services_lib/libs/google-play-services.jar
-outjars google-play-services-ads.jar

-libraryjars android-sdk/extras/android/support/v4/android-support-v4.jar
-libraryjars android-sdk/platforms/android-20/android.jar

-verbose
-forceprocessing
-dontoptimize
-dontobfuscate
-dontwarn com.google.**.R
-dontwarn com.google.**.R$*
-dontnote

-keep public class com.google.ads.** {
    public protected *;
}

-keep public class com.google.android.gms.ads.** {
    public protected *;
}

-keep class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    java.lang.String NULL;
}