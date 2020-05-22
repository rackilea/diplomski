static jlong nativeReadFromParcel(JNIEnv* env, jclass clazz, jlong nativeObject, jobject parcelObj) {
  Parcel* parcel = parcelForJavaObject(env, parcelObj);
  if (parcel == NULL) {
    doThrowNPE(env);
    return 0;
  }

  android::view::Surface surfaceShim;

  // Calling code in Surface.java has already read the name of the Surface
  // from the Parcel
  surfaceShim.readFromParcel(parcel, /*nameAlreadyRead*/true);

  sp<Surface> self(reinterpret_cast<Surface *>(nativeObject));

  // update the Surface only if the underlying IGraphicBufferProducer
  // has changed.
  if (self != nullptr
        && (IInterface::asBinder(self->getIGraphicBufferProducer()) ==
                IInterface::asBinder(surfaceShim.graphicBufferProducer))) {
      // same IGraphicBufferProducer, return ourselves
      return jlong(self.get());
  }

  sp<Surface> sur;
  if (surfaceShim.graphicBufferProducer != nullptr) {
    // we have a new IGraphicBufferProducer, create a new Surface for it
    sur = new Surface(surfaceShim.graphicBufferProducer, true);
    // and keep a reference before passing to java
    sur->incStrong(&sRefBaseOwner);
  }

  if (self != NULL) {
    // and loose the java reference to ourselves
    self->decStrong(&sRefBaseOwner);
  }

  return jlong(sur.get());
}