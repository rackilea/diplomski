public class Natives {
    public static native void printf(final String WhatToPrintHere);
}

public class Main {
    public static void main(String args[]) {
        Natives.printf("Testing printing from Java");
    }
}


extern "C" JNIEXPORT void Java_Natives_printf(JNIEnv* env, jobject obj, jstring WhatToPrintHere)
{
    const char* Str = env->GetStringUTFChars(WhatToPrintHere, 0);

    std::cout<< Str <<"\n";

    env->ReleaseStringUTFChars(WhatToPrintHere, Str);
}