List<LatLng> latLng = new ArrayList<LatLng>();

for (int i = 0; i < routesWithSameID.size(); i++){
            String latString = routesWithSameID.get(i).getLat();
            String lngString = routesWithSameID.get(i).getLng();
            double latitude = Double.parseDouble(latString);
            double longitude = Double.parseDouble(lngString);
            LatLng location = new LatLng(latitude, longitude);
            latLng.add(location);
        }