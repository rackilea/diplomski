public void addItem(GeoPoint p, String title, String snippet){
    OverlayItem newItem = new OverlayItem(p, title, snippet);
    overlayItemList.removeAll();
    overlayItemList.add(newItem);
    populate();
}