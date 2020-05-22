JNIEXPORT jboolean JNICALL
Java_java_io_Console_echo(JNIEnv *env, jclass cls, jboolean on)
{
    DWORD fdwMode;
    jboolean old;
    if (! GetConsoleMode(hStdIn, &fdwMode)) {
        JNU_ThrowIOExceptionWithLastError(env, "GetConsoleMode failed");
        return !on;
    }
    old = (fdwMode & ENABLE_ECHO_INPUT) != 0;
    if (on) {
        fdwMode |= ENABLE_ECHO_INPUT;
    } else {
        fdwMode &= ~ENABLE_ECHO_INPUT;
    }
    if (! SetConsoleMode(hStdIn, fdwMode)) {
        JNU_ThrowIOExceptionWithLastError(env, "SetConsoleMode failed");
    }
    return old;
}