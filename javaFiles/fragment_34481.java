// It is assumed here that the length of the array is sufficient, perhaps because
// we just created this (Java) array.
jint *idArray = (jint *) env->GetPrimitiveArrayCritical(jintArray1, NULL);

for (uint32_t i = 0; i < nbCameras; ++i) {
    idArray[i] = cam.idCamera.data[i];
}
env->ReleasePrimitiveArrayCritical(jintArray1, idArray, 0);