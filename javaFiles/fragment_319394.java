public class ViewMap extends MapActivity
{
    MapView mapView;
    MapController mc,mc1;
    GeoPoint p,q;
    double latPoint,latPoint1,lngPoint,lngPoint1;
    private List<Overlay> mapOverlays;
    private Projection projection;
    int fromlatE6,fromlonE6,tolatE6,tolonE6;

class MapOverlay extends com.google.android.maps.Overlay
{
    public boolean draw(Canvas canvas, MapView mapView,boolean shadow, long when) 
    {
        super.draw(canvas, mapView, shadow);                   

        //---translate the GeoPoint to screen pixels---
        Point screenPts = new Point();

        mapView.getProjection().toPixels(p, screenPts);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
        canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);   

        mapView.getProjection().toPixels(q, screenPts);
        Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.marker);            
        canvas.drawBitmap(bmp1, screenPts.x, screenPts.y-50, null);

        return true;
    }  
} 

@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mapview);

    latPoint1 = Double.valueOf(RestingSpotProfile.LAT);
    lngPoint1 = Double.valueOf(RestingSpotProfile.LON);

    mapView = (MapView) findViewById(R.id.mapView);
    LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);  
    android.view.View  zoomView = mapView.getZoomControls(); 

    zoomLayout.addView(zoomView, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)); 
    mapView.displayZoomControls(true);

    mc = mapView.getController();
    mc1 = mapView.getController();

    LocationManager myManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    if(myManager != null)
    {
        String param = (String)myManager.getProviders(true).get(0);
        Location loc = myManager.getLastKnownLocation(param); 
        if(loc != null)
        {
            latPoint = loc.getLatitude();
            lngPoint = loc.getLongitude();

        }
        else
                Log.e("GoogleMaps ","Error: Location  is null");
    }
    else
        Log.e("GoogleMaps ","Error: Location Manager is null");


    p = new GeoPoint
    (
        (int) (latPoint * 1E6),
        (int) (lngPoint * 1E6)
     );

    //---Add a location marker---
    MapOverlay mapOverlay = new MapOverlay();
    List<Overlay> listOfOverlays = mapView.getOverlays();
    listOfOverlays.clear();
    listOfOverlays.add(mapOverlay);  

    q = new GeoPoint((int) ((latPoint1 + 2.0)* 1E6), (int) ((lngPoint1 + 2.0)* 1E6));

    tolonE6=(int)((latPoint + 2.0)*1e6);
    tolatE6=(int)((lngPoint + 2.0)*1e6);

    mc.animateTo(p);
    mc.setZoom(9);  

  //---Add a location marker---
    MapOverlay mapOverlay1 = new MapOverlay();
    List<Overlay> listOfOverlays1 = mapView.getOverlays();
    listOfOverlays1.clear();
    listOfOverlays.add(mapOverlay1);  

    mapView.invalidate();      

    mc1.animateTo(q);
    mc1.setZoom(17);  
    mapView.invalidate();    

    mapView.invalidate();
}

@Override
protected boolean isRouteDisplayed()
{
    return false;
}

public class MyOverlay extends Overlay
{
    private GeoPoint gp1;
    private GeoPoint gp2;

    public MyOverlay(int fromlatE6,int fromlonE6,int tolatE6,int tologE6) 
    {               
        int flat=0,flog=0,tlat=0,tlog=0;
        flat=fromlatE6;
        flog=fromlonE6;
        tlat=tolatE6;
        tlog=tologE6;

        gp1 = new GeoPoint(flat,flog);
        gp2 = new GeoPoint(tlat,tlog);
    }
}