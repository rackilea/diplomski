157 JNIEXPORT jint JNICALL
  158 Java_sun_nio_ch_FileChannelImpl_force0(JNIEnv *env, jobject this,
  159                                        jobject fdo, jboolean md)
  160 {
  161     jint fd = fdval(env, fdo);
  162     int result = 0;
  163 
  164     if (md == JNI_FALSE) {
  165         result = fdatasync(fd);
  166     } else {
  167         result = fsync(fd);
  168     }
  169     return handle(env, result, "Force failed");
  170 }