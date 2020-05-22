/*
 * At this point we have the arguments to the application, and we need to
 * check with original stdargs in order to compare which of these truly
 * needs expansion. cmdtoargs will specify this if it finds a bare
 * (unquoted) argument containing a glob character(s) ie. * or ?
 */
jobjectArray
CreateApplicationArgs(JNIEnv *env, char **strv, int argc)
{
   // (***snip***)
    NULL_CHECK0(mid = (*env)->GetStaticMethodID(env, cls,
                                                "expandArgs",
                                                "([Ljava/lang/String;)[Ljava/lang/String;"));

    // expand the arguments that require expansion, the java method will strip
    // out the indicator character.
    NULL_CHECK0(inArray = NewPlatformStringArray(env, nargv, argc));
    outArray = (*env)->CallStaticObjectMethod(env, cls, mid, inArray);