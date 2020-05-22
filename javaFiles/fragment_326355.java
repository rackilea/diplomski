private void writeObject(ObjectOutputStream out) throws IOException {
  out.defaultWriteObject();

  double[] coords = new double[2 * latLngArrayList.size()];
  int i = 0;
  for (LatLng latLng : latLngArrayList) {
    coords[2*i+0] = latLng.latitude;
    coords[2*i+1] = latLng.longitude;
    ++i;
  }
  out.writeObject(coords);
}

private void readObject(ObjectInputStream in)
    throws ClassNotFoundException, IOException {
  in.defaultReadObject();
  double[] coords = (double[]) in.readObject();
  // + Check that coords.length is even.
  latLngArrayList = new ArrayList<>(coords.size() / 2);
  for (int i = 0; i < coords.size(); i += 2) {
    latLngArrayList.add(new LatLng(coords[i], coords[i+1]));
  }
}