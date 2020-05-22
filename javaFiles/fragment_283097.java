sp<Surface> Surface::readFromParcel(const Parcel& data) {
  Mutex::Autolock _l(sCachedSurfacesLock);
  sp<IBinder> binder(data.readStrongBinder());
  sp<Surface> surface = sCachedSurfaces.valueFor(binder).promote();
  if (surface == 0) {
   surface = new Surface(data, binder);
   sCachedSurfaces.add(binder, surface);
  } else {
    // The Surface was found in the cache, but we still should clear any
    // remaining data from the parcel.
    data.readStrongBinder();  // ISurfaceTexture
    data.readInt32();         // identity
  }
  if (surface->mSurface == NULL && surface->getISurfaceTexture() == NULL) {
    surface = 0;
  }
  cleanCachedSurfacesLocked();
  return surface;
}