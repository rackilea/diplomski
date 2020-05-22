mcursor = getCursor(); //or whatever
if(mcursor != null && mcursor.moveToFirst())
{
        do
        {
        String tname = mcursor.getString(1);
        String tmessage = mcursor.getString(2);
        String tlink = mcursor.getString(3);
        String tsname = mcursor.getString(6);
        Double tlat = mcursor.getDouble(2);
        Double tlng = mcursor.getDouble(3);

        GeoPoint point = new GeoPoint(tlat,tlng);
        OverlayItem overlayitem = new OverlayItem(point, tname, tmessage);
        itemizedoverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedoverlay);


        }while(mcursor.moveToNext());

}