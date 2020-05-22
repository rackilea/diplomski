import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
// et al...

public void setupCurrlocation(LatLng MUSEUM) {
    GoogleMap googleMap = ((MapFragment) fragmentManager.
                    findFragmentById(R.id.map)).getMap();
    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    Marker marker = googleMap.addMarker(new MarkerOptions().position(latLng).title(null));
    CameraPosition cameraPosition = new CameraPosition.Builder().target(MUSEUM).zoom(10).bearing(70).tilt(25)
                            .build();
    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

}