public Func1<Object, Boolean> anyToFalse() {
    return new Func1<Object, Boolean>() {
        @Override
        public Boolean call(LatLng latLng) {
            return false;
        }
    }
}