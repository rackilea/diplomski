package com.stackoverflow.jni.directx;

/*
 * GENERATE HEADER FILE FROM GENERATED CLASS AS NEEDED VIA
 *   javah com.stackoverflow.jni.directx.NativeClazz
 */
public class NativeClazz {

/**
 * Load C++ Library
 */
static {
    // Always fun to do this in a static block!
        System.loadLibrary("DirectX");
}

private static native void GetNativeBuffer(IntBuffer Buffer);
}