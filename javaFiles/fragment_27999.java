JNIEXPORT void JNICALL Java_recipeNo026_PassArray_passDoubleArray
  (JNIEnv * env, jclass obj, jdoubleArray array) {

  printf ("Double array\n");
  jboolean isCopy;
  jdouble *doubleBody = (*env)->GetDoubleArrayElements(env, array, &isCopy);
  (*env)->ReleaseDoubleArrayElements(env, array, doubleBody, JNI_ABORT); 
}