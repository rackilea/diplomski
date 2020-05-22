// Invariant - exactly one of mMap / mParcelledData will be null
// (except inside a call to unparcel)

ArrayMap<String, Object> mMap = null;

/*
 * If mParcelledData is non-null, then mMap will be null and the
 * data are stored as a Parcel containing a Bundle.  When the data
 * are unparcelled, mParcelledData willbe set to null.
 */
Parcel mParcelledData = null;