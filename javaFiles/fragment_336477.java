jstring Java_Package_MyTester_NMethod
 (JNIEnv *env, jobject obj, jint first, jint second) {
  jint result_i = first * second;
  char buf[64]; // assumed large enough to cope with result

  sprintf(buf, "%d", result_i);  // error checking omitted

  return (*env)->NewStringUTF(env, buf);      
}