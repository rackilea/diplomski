jobject obj = ... // This is the object you want to call the method on
jcharArray arr = (jcharArray) (*env)->CallObjectMethod(env, obj, mid);
int count = (*env)->GetArrayLength(env, arr);
jchar* chars = (*env)->GetCharArrayElements(env, arr, 0);
// Here, "chars" is a C pointer to an array of "count" characters. It's NOT
// going to be 0-terminated, so be careful! Here's where you would do your
// logging or whatever. One possible way to do this is by turning the `jchar`
// array into a proper 0-terminated character string:
char * message = malloc(count + 1);
memcpy(message, chars, count);
message[count] = 0;
LOGD("NDK:LC: [%s]", message);

// When you're done you must call this!
(*env)->ReleaseCharArrayElements(env, arr, chars, 0);