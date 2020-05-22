jclass jc_your_class = (*env)->FindClass(env, "com.your.util.DeviceInfo" ); // YOUR DeviceInfo class
jmethodID jmid_is_glass_device = (*env)->GetMethodID(env, jc_your_class, "isGlassDevice", "()Z"); // Get info method.

jboolean jb_is_glass_device = (*env)->CallStaticBooleanMethod(env, jc_your_class, jmid_is_glass_device);    

if (jb_is_glass_device == JNI_TRUE){
    // Your code goes here...
}