<your.own.package.path>;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Picture;
import android.graphics.Rect;
import android.location.Location;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;
import com.iqqn.uppgift5.GameMapActivity;

public class ScaleBarOverlay extends Overlay{

    // ===========================================================
    // Fields
    // ===========================================================

    // Defaults

    boolean enabled = true;

    float xOffset = 10;
    float yOffset = 10;
    float lineWidth = 2;
    int textSize = 12;

    boolean imperial = false;
    boolean nautical = false;

    boolean latitudeBar = true;
    boolean longitudeBar = false;

    // Internal

    protected final MapView mapView;
    protected final GameMapActivity master;

    private Context context;

    protected final Picture scaleBarPicture = new Picture();
    private final Matrix scaleBarMatrix = new Matrix();

    private int lastZoomLevel = -1;

    float xdpi;
    float ydpi;
    int screenWidth;
    int screenHeight;

    // ===========================================================
    // Constructors
    // ===========================================================

    public ScaleBarOverlay(Context _context, GameMapActivity master, MapView mapView) {
        super();

        this.master = master;
        this.context = _context;
        this.mapView = mapView;

        xdpi = this.context.getResources().getDisplayMetrics().xdpi;
        ydpi = this.context.getResources().getDisplayMetrics().ydpi;

        screenWidth = this.context.getResources().getDisplayMetrics().widthPixels;
        screenHeight = this.context.getResources().getDisplayMetrics().heightPixels;

    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the lineWidth
     */
    public float getLineWidth() {
        return lineWidth;
    }

    /**
     * @param lineWidth the lineWidth to set
     */
    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * @return the imperial
     */
    public boolean isImperial() {
        return imperial;
    }

    /**
     * @param imperial the imperial to set
     */
    public void setImperial() {
        this.imperial = true;
        this.nautical = false;
        createScaleBarPicture();
    }

    /**
     * @return the nautical
     */
    public boolean isNautical() {
        return nautical;
    }

    /**
     * @param nautical the nautical to set
     */
    public void setNautical() {
        this.nautical = true;
        this.imperial = false;
        createScaleBarPicture();
    }

    public void setMetric() {
        this.nautical = false;
        this.imperial = false;
        createScaleBarPicture();
    }

    public void drawLatitudeScale(boolean latitude) {
        this.latitudeBar = latitude;
    }

    public void drawLongitudeScale(boolean longitude) {
        this.longitudeBar = longitude;
    }

    @Override
    public void draw(Canvas canvas, MapView localMapView, boolean shadow) {
        if (this.enabled) {
            // Draw the overlay
            if (shadow == false) {
                final int zoomLevel = localMapView.getZoomLevel();

                if (zoomLevel != lastZoomLevel) {
                    lastZoomLevel = zoomLevel;
                    createScaleBarPicture();
                }

                this.scaleBarMatrix.setTranslate(-1 * (scaleBarPicture.getWidth() / 2 - 0.5f), -1 * (scaleBarPicture.getHeight() / 2 - 0.5f));
                this.scaleBarMatrix.postTranslate(xdpi/2, ydpi/2 + canvas.getHeight()-50);

                canvas.save();
                canvas.setMatrix(scaleBarMatrix);
                canvas.drawPicture(scaleBarPicture);
                canvas.restore();
            }
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    public void disableScaleBar() {
        this.enabled = false;
    }

    public boolean enableScaleBar() {
        return this.enabled = true;
    }

    private void createScaleBarPicture() {
        // We want the scale bar to be as long as the closest round-number miles/kilometers
        // to 1-inch at the latitude at the current center of the screen.

        Projection projection = mapView.getProjection();

        if (projection == null) {
            return;
        }

        Location locationP1 = new Location("ScaleBar location p1");
        Location locationP2 = new Location("ScaleBar location p2");

        // Two points, 1-inch apart in x/latitude, centered on screen
        GeoPoint p1 = projection.fromPixels((int) ((screenWidth / 2) - (xdpi / 2)), screenHeight/2);
        GeoPoint p2 = projection.fromPixels((int) ((screenWidth / 2) + (xdpi / 2)), screenHeight/2);

        locationP1.setLatitude(p1.getLatitudeE6()/1E6);
        locationP2.setLatitude(p2.getLatitudeE6()/1E6);
        locationP1.setLongitude(p1.getLongitudeE6()/1E6);
        locationP2.setLongitude(p2.getLongitudeE6()/1E6);

        float xMetersPerInch = locationP1.distanceTo(locationP2);

        p1 = projection.fromPixels(screenWidth/2, (int) ((screenHeight / 2) - (ydpi / 2)));
        p2 = projection.fromPixels(screenWidth/2, (int) ((screenHeight / 2) + (ydpi / 2)));

        locationP1.setLatitude(p1.getLatitudeE6()/1E6);
        locationP2.setLatitude(p2.getLatitudeE6()/1E6);
        locationP1.setLongitude(p1.getLongitudeE6()/1E6);
        locationP2.setLongitude(p2.getLongitudeE6()/1E6);

        float yMetersPerInch =  locationP1.distanceTo(locationP2);

        final Paint barPaint = new Paint();
        barPaint.setColor(Color.BLACK);
        barPaint.setAntiAlias(true);
        barPaint.setStyle(Style.FILL);
        barPaint.setAlpha(255);

        final Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Style.FILL);
        textPaint.setAlpha(255);
        textPaint.setTextSize(textSize);

        final Canvas canvas = scaleBarPicture.beginRecording((int)xdpi, (int)ydpi);

        if (latitudeBar) {
            String xMsg = scaleBarLengthText(xMetersPerInch, imperial, nautical);
            Rect xTextRect = new Rect();
            textPaint.getTextBounds(xMsg, 0, xMsg.length(), xTextRect);

            int textSpacing = (int)(xTextRect.height() / 5.0);

            canvas.drawRect(xOffset, yOffset, xOffset + xdpi, yOffset + lineWidth, barPaint);
            canvas.drawRect(xOffset + xdpi, yOffset, xOffset + xdpi + lineWidth, yOffset + xTextRect.height() + lineWidth + textSpacing, barPaint);

            if (!longitudeBar) {
                canvas.drawRect(xOffset, yOffset, xOffset + lineWidth, yOffset + xTextRect.height() + lineWidth + textSpacing, barPaint);
            }
            canvas.drawText(xMsg, (xOffset + xdpi/2 - xTextRect.width()/2), (yOffset + xTextRect.height() + lineWidth + textSpacing), textPaint);
        }

        if (longitudeBar) {
            String yMsg = scaleBarLengthText(yMetersPerInch, imperial, nautical);
            Rect yTextRect = new Rect();
            textPaint.getTextBounds(yMsg, 0, yMsg.length(), yTextRect);

            int textSpacing = (int)(yTextRect.height() / 5.0);

            canvas.drawRect(xOffset, yOffset, xOffset + lineWidth, yOffset + ydpi, barPaint);
            canvas.drawRect(xOffset, yOffset + ydpi, xOffset + yTextRect.height() + lineWidth + textSpacing, yOffset + ydpi + lineWidth, barPaint);

            if (! latitudeBar) {
                canvas.drawRect(xOffset, yOffset, xOffset + yTextRect.height() + lineWidth + textSpacing, yOffset + lineWidth, barPaint);
            }                       

            float x = xOffset + yTextRect.height() + lineWidth + textSpacing;
            float y = yOffset + ydpi/2 + yTextRect.width()/2;

            canvas.rotate(-90, x, y);
            canvas.drawText(yMsg, x, y + textSpacing, textPaint);

        }

        scaleBarPicture.endRecording();
    }

    private String scaleBarLengthText(float meters, boolean imperial, boolean nautical) {
        if (this.imperial) {
            if (meters >= 1609.344) {
                return (meters / 1609.344) + "mi";
            } else if (meters >= 1609.344/10) {
                return ((meters / 160.9344) / 10.0) + "mi";
            } else {
                return (meters * 3.2808399) + "ft";
            }
        } else if (this.nautical) {
            if (meters >= 1852) {
                return ((meters / 1852)) + "nm";
            } else if (meters >= 1852/10) {
                return (((meters / 185.2)) / 10.0) + "nm";
            } else {
                return ((meters * 3.2808399)) + "ft";
            }
        } else {
            if (meters >= 1000) {
                return ((meters / 1000)) + "km";
            } else if (meters > 100) {
                return ((meters / 100.0) / 10.0) + "km";
            } else {
                return meters + "m";
            }
        }
    }

    @Override
    public boolean onTap(GeoPoint point, MapView mapView) {
        // Do not react to screen taps.
        return false;
    }
}