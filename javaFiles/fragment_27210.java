export ANDROID_ROOT=!!!PATH-TO-AOSP!!!/out/debug/host/linux-x86/product/generic_x86_64/system

# configure bootclasspath
export BOOTCLASSPATH=$ANDROID_ROOT/framework/core.jar:$ANDROID_ROOT/framework/ext.jar:$ANDROID_ROOT/framework/framework.jar:$ANDROID_ROOT/framework/android.policy.jar:$ANDROID_ROOT/framework/services.jar

# this is where we create the dalvik-cache directory; make sure it exists
export ANDROID_DATA=/tmp/dalvik_$USER