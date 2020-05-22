public class ClusterRequest implements ClusterItem {
private final LatLng mPosition;
public final String stopName; //Add a "global variable" here so it can be accessible in the MapIconRender class.

public ClusterRequest(double lat, double lng, String _stopName) {
    mPosition = new LatLng(lat, lng);
    stopName = _stopName;
}

@Override
public LatLng getPosition() {
    return mPosition;
  }
}