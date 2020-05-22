static jint testFunction(JNIEnv* env, jclass c, jobject obj,
 jcharArray chsArray, int offset, int len, jcharArray dstArray) {

/**/println("** testFunction 1");
    jchar* dst = env->GetCharArrayElements(dstArray, NULL);

/**/println("** testFunction 2");
    if (dst != NULL) {
/**/println("** testFunction 3");
        UChar *str = new UChar[len];
/**/println("** testFunction 4");

        //populate str here from an ICU4C function

/**/println("** testFunction 5");
        for (int i=0; i<len; i++)
            dst[i] = str[i];      //this might be the problematic piece of code (can I issue an assignment like this?)
        }
/**/println("** testFunction 6");
    }

    env->ReleaseCharArrayElements(dstArray, dst, 0);
/**/println("** testFunction 7");
}