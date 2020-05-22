private void addOverlaysToMapFromManagedInterestPoints() {

       this.mapOverlays = myMap.getOverlays();

        GeoPoint point;
        OverlayItem overlayitem;



       for( managed_interest_point mip : managedObjectManager.interestPoints )
        {

            if(mip==null)
            {
                Log.d("MainActivity","this should not happen!");
            }

            TypeOfPoint type = getEnumForTypeOfPoint(mip.ZTYPEOFPOINT);
            if(type!=null)
            {
                switch (type) {
                case kAnimalHospital:
                    point = new GeoPoint(degreesToMicrodegreesConversion(mip.ZLATITUDE),degreesToMicrodegreesConversion(mip.ZLONGITUDE));
                    overlayitem  = new OverlayItem(point, mip.ZTITLE, mip.ZSUBTITLE);                   
                    this.animalHospitalOverlay.addOverlay(overlayitem);
                    Log.d("MainActivity","added animalHospital");
                    break;
                case kStore:
                    point = new GeoPoint(degreesToMicrodegreesConversion(mip.ZLATITUDE),degreesToMicrodegreesConversion(mip.ZLONGITUDE));
                    overlayitem = new OverlayItem(point, mip.ZTITLE, mip.ZSUBTITLE);                                     
                    this.storesOverlay.addOverlay(overlayitem); 
                    Log.d("MainActivity","added Store point");
                    break;
                case kVeterinary:                       
                    point = new GeoPoint(degreesToMicrodegreesConversion(mip.ZLATITUDE),degreesToMicrodegreesConversion(mip.ZLONGITUDE));
                     overlayitem = new OverlayItem(point, mip.ZTITLE, mip.ZSUBTITLE);                   
                     this.veterinariesOverlay.addOverlay(overlayitem);
                     Log.d("MainActivity","added veterinary point");
                     break;
                default:
                    Log.d("MainActivity", "unknown enum");
                    break;
                }//end switch
            }//end if 
        }//end foreach

      this.storesOverlay.callToPopulate();
      this.veterinariesOverlay.callToPopulate();
      this.animalHospitalOverlay.callToPopulate();


       this.mapOverlays.add(this.storesOverlay);
       this.mapOverlays.add(this.veterinariesOverlay);
       this.mapOverlays.add(this.animalHospitalOverlay);    
       Log.d("MainActivity","end of foreach in add overlays to map ");


}



public class AnnotationsOverlay extends ItemizedOverlay {

private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
Context mContext;



public AnnotationsOverlay(Drawable defaultMarker) {
    super(boundCenterBottom(defaultMarker));

}

public AnnotationsOverlay(Drawable defaultMarker,Context context)
{
    super(boundCenterBottom(defaultMarker));
    mContext=context;

}

@Override
protected OverlayItem createItem(int i) {


    return mOverlays.get(i);
}

@Override
public int size() {

    return mOverlays.size();
}

//show calloutAssesory view tapped för oss iPhöne människor
@Override
protected boolean onTap(int index) {
  OverlayItem item = mOverlays.get(index);
  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
  dialog.setTitle(item.getTitle());
  dialog.setMessage(item.getSnippet());
  dialog.show();
  return true;
}

public void addOverlay(OverlayItem overlay)
{
    mOverlays.add(overlay);
    //populate();
}

public void callToPopulate()
{
    populate();
}



}