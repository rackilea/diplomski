mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
          @Override
          public boolean onMarkerClick(final Marker marker) {
              if (marker.getTitle().equals("Ecolab")) {
                  Intent ecolabIntent = new Intent(MapS.this, activity_ecolab.class);
                  startActivity(ecolabIntent);
              }

              else if (marker.getTitle().equals("Alma & Cantor en Zweetkelder")) {
                  Intent AlmaIntent = new Intent(MapS.this, activity_acz.class);
                  startActivity(AlmaIntent);
              }
              return true;
          }
     }
);