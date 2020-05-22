@Override
public final void validateRequestPermissionsRequestCode(int requestCode) {
    // We use 16 bits of the request code to encode the fragment id when
    // requesting permissions from a fragment. Hence, requestPermissions()
    // should validate the code against that but we cannot override it as
    // we can not then call super and also the ActivityCompat would call
    // back to this override. To handle this we use dependency inversion
    // where we are the validator of request codes when requesting
    // permissions in ActivityCompat.
    if (!mRequestedPermissionsFromFragment
            && requestCode != -1 && (requestCode & 0xffff0000) != 0) {
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}