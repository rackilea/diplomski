final LocationManager manag = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            //Choix du service de localisation en fonction de critères
            Criteria crit = new Criteria();
            crit.setCostAllowed(false);
            crit.setAccuracy(100); //précis à 1km pret
            String choix_source = manag.getBestProvider(crit, true);
            //demander la position courante
            manag.requestLocationUpdates(choix_source, 10000, 0, new LocationListener(){ //toutes les 10 secondes
                //Lors de la capture de la position
                public void onLocationChanged(Location location) {
                ....