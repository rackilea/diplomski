public class MyMarker extends Marker {
        private Context ctx;
 
        
        public MyMarker(Context ctx, LatLong latLong, Bitmap bitmap, int horizontalOffset,
                        int verticalOffset) {

            super(latLong, bitmap, horizontalOffset, verticalOffset);
            this.ctx = ctx;
        }


        @Override
        public boolean onTap(LatLong tapLatLong, Point layerXY, Point tapXY) {
            if (this.contains(layerXY, tapXY)) {
}
}