private class myLocationListener implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {          
            if(location!=null){             
                locManager.removeUpdates(locListener);
                String longitude = "Longitude: " +location.getLongitude();
                String latitude = "Latitude: " +location.getLatitude();
                String altitiude = "Altitiude: " + location.getAltitude();          
                String cityName;

                Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
                public List<Address> addresses= gcd.getFromLocation (double latitude1, double longitude1, int maxResults)   

                List<Address> addresses;
                try {
                    addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    if (addresses.size() > 0)
                        System.out.println(addresses.get(0).getLocality());
                    cityName=addresses.get(0).getLocality();
                } catch (IOException e) {                   
                    e.printStackTrace();
                }
                showLocation.setText("City Name: "+cityName+"+ "\n"+longitude + "\n" + latitude + "\n" + altitiude);
                progress.setVisibility(View.GONE);
            }
        }