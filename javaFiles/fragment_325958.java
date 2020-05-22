package com.example.mymap;
import java.util.ArrayList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class ItemOverLay extends ItemizedOverlay<OverlayItem> {

private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
GeoPoint prePoint=null,currentPoint=null;
MapView mapView=null;
Paint paint=new Paint();

public ItemOverLay(GeoPoint prePoint,GeoPoint currentPoint, Drawable defaultMarker,MapView mapview) {

    super(boundCenterBottom(defaultMarker));
    this.currentPoint=currentPoint;
    this.prePoint = prePoint;
    mapView=mapview;
    // TODO Auto-generated constructor stub
}
public ItemOverLay(Drawable defaultMarker) {
    super(defaultMarker);
    // TODO Auto-generated constructor stub
}


public void addOverlay(OverlayItem item){
    mOverlays.add(item);
    populate();
}
@Override
protected OverlayItem createItem(int i) {
     // TODO Auto-generated method stub
    return mOverlays.get(i);
}



    @Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow) {

        super.draw(canvas, mapView, shadow);

        Paint paint=new Paint();
        Point screenCoords=new Point();
        Point screenCoords1=new Point();

        mapView.getProjection().toPixels(prePoint, screenCoords);
        int x1=screenCoords.x;
        int y1=screenCoords.y;

        mapView.getProjection().toPixels(currentPoint, screenCoords1);
        int x2=screenCoords1.x;
        int y2=screenCoords1.y;

        paint.setStrokeWidth(1);
        canvas.drawLine(x1, y1, x2, y2, paint);




    }

        @Override
    public int size() {
        // TODO Auto-generated method stub
        return mOverlays.size();
    }