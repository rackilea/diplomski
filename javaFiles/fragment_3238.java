List<Polyline> polylines = new ArrayList<>();

// When adding the polyline add to the list
polylines.add(mMap.addPolyline(lineOptions));

// To remove all the polyline
for(Polyline polyline: polylines) {
  polyline.remove();
}

// then clear the list
polylines.clear();