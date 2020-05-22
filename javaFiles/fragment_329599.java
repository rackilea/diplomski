JNIEXPORT void JNICALL Java_com_example_foo_Foo_eyeDetection(JNIEnv *env, jclass FooClass, jlong matRgba) {
  Mat& rgba = *(Mat*)matRgba;
  jmethodID mid_getCoord = env->GetStaticMethodID(FooClass, "getCoord", "(II)V");
   String eye_cascade_name = "test.eyes.cascade.xml";

  CascadeClassifier eyes_cascade;
  std::vector<Rect> eyes;
  eyes_cascade.detectMultiScale(…);
  for (size_t i = 0; i < eyes.size(); i++) {
    env->CallStaticVoidMethod(FooClass, mid_getCoord, eyes[i].x, eyes[i].y);
    …
  }
}