geoPoints = new ArrayList<GeoPoint>(geoPoints.size());
for (int i = 0; i < geoPoints.size() - 1; i++)
        {
            geoPoints.add(gp.get(i));
            items.add(new OverlayItem(geoPoints.get(i)));
        }