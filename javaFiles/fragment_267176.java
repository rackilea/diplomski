public class YourMapFragment extends Fragment implements OnMapReadyCallback { 
...
@Override
public void onMapReady(GoogleMap googleMap) {
mMap = googleMap;
mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPosition,16));

    mMap.addMarker(new MarkerOptions()
            .position(currentPosition)
            .snippet("Lat:" + lat + "Lng:" + log));
}

    ...
    }