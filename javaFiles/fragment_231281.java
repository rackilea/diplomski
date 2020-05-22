void vadd_row(int arg1, int arg2, va_list argp) {
    ... your function ...
}

void add_row(int arg1, int arg2, ...) {
    va_list argp;

    va_start(argp, arg2);
    vadd_row(int arg1, int arg2, argp);
    va_end(argp);
}


JNIEXPORT void JNICALL mypackage_MyClass_addRow(JNIEnv *env, jobject this, jint arg1, jint arg2, jobjectArray jarg_array) {
    va_list argp;
    /* need to construct argp, see link below for hints[1]; go through each element
       of the java array, get the object; convert to primitive value or ANSI string,
       then encode it into the va_list */
    vadd_row((int)arg1, (int)arg2, argp);
}