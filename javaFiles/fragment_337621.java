/* Build argument array */
mainArgs = NewPlatformStringArray(env, argv, argc);
if (mainArgs == NULL) {
    ReportExceptionDescription(env);
    goto leave;
}

/* Invoke main method. */
(*env)->CallStaticVoidMethod(env, mainClass, mainID, mainArgs);

/*
 * The launcher's exit code (in the absence of calls to
 * System.exit) will be non-zero if main threw an exception.
 */
 ret = (*env)->ExceptionOccurred(env) == NULL ? 0 : 1;