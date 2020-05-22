public class MapsActivity extends FragmentActivity implements .... {
...............
@Override
protected void onCreate(Bundle savedInstanceState) {
............
      }
public void send(View view) {
    try {
        Geocoder gc = new Geocoder(this, Locale.getDefault());
        List<Address> list = gc.getFromLocationName(message, 1);
.........}
    }
............
}