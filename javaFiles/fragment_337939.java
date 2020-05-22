@Override
public int compare(final Placemark pm, final Placemark pm2) {
    float[] left = new float[1];
    float[] right = new float[1];

    Location.distanceBetween(this.lat, this.lon, pm.lat, pm.lon, left);
    Location.distanceBetween(this.lat, this.lon, pm2.lat, pm2.lon, right);

    return left[0] - right[0]; // or is it right[0] - left[0] ? :x
}