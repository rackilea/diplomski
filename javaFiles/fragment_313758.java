package org.stackoverflow.jni;

import org.stackoverflow.data.BeanObject;

public class NativeClazz {

    // Static area for forced initialization
    static {

        // Load Native Library (C++); calls JNI_OnLoad()
        System.loadLibrary("Native_Library_File_Name");
    }       

    /**
     * A static native method you plan to call.
     */
    public static native void staticNativeMethod(BeanObject bean);

    /**
     * A non-static native method you plan to call, to show this also works with 
     * instantiated Java classes.
     */
    public native void instanceNativeMethod(BeanObject bean);
}