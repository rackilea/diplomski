// The distance you want to increase your square (in meters)
double distance = 104.52;

// A List of LatLng defining your user's input
// (Two latLng define a square)
List<LatLng> positions = new ArrayList<>();
positions.add(new LatLng(40.22861, -3.95567));
positions.add(new LatLng(40.22884, -3.95342));

// Create a LatLngBounds.Builder and include your positions
LatLngBounds.Builder builder = new LatLngBounds.Builder();
for (LatLng position : positions) {
    builder.include(position);
}

// Calculate the bounds of the initial positions
LatLngBounds initialBounds = builder.build();

// Increase the bounds by the given distance
// Notice the distance * Math.sqrt(2) to increase the bounds in the directions of northeast and southwest (45 and 225 degrees respectively)
LatLng targetNorteast = SphericalUtil.computeOffset(initialBounds.northeast, distance * Math.sqrt(2), 45);
LatLng targetSouthwest = SphericalUtil.computeOffset(initialBounds.southwest, distance * Math.sqrt(2), 225);

// Add the new positions to the bounds
builder.include(targetNorteast);
builder.include(targetSouthwest);

// Calculate the bounds of the final positions
LatLngBounds finalBounds = builder.build();