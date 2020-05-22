LatLng city = new LatLng(53.121896, 18.010110);

List<LatLng> pts = new ArrayList<>();
pts.add(new LatLng(53.520790, 17.404158));
pts.add(new LatLng(53.450445, 19.209022));
pts.add(new LatLng(52.525305, 19.303601));
pts.add(new LatLng(52.659365, 17.656366));

bounds = new LatLngBounds(pts.get(3), pts.get(1));

boolean contains1 = PolyUtil.containsLocation(city.latitude, city.longitude, pts, true);
System.out.println("contains1: " + contains1);

boolean contains2 = bounds.contains(city);
System.out.println("contains2: " + contains2);