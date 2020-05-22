package com.stackoverflow.jni.opengl;

/*
 * GENERATE HEADER FILE FROM GENERATED CLASS AS NEEDED VIA
 *   javah com.stackoverflow.jni.opengl.NativeClazz
 */
public class NativeClazz {

/**
 * Load C++ Library
 */
static {
    // Always fun to do this in a static block!
        System.loadLibrary("OpenGL");
}

private static native void GetNativeBuffer(IntBuffer Buffer);
}