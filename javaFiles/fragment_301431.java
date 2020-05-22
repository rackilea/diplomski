public class DisplayMap extends Activity {

@Override
public void onCreate(Bundle b) {
super.onCreae(b);
getSize();
}
public void getSize() {

Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;
    int height = size.y;
}