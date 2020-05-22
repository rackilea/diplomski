mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
       @Override
       public boolean onMarkerClick(Marker marker) {
          Log.d(LOG_TAG, "clicked marker id: " + marker.getId());
          Player2 nearbyPlayer = playerMap.get(marker.getId());
          PlayerDetailsFragment playerDetailsFragment = new PlayerDetailsFragment();
          Bundle bundle = new Bundle();
          bundle.putString("player_details_username", nearbyPlayer.getSurname());
          if (nearbyPlayer.getType() == -1){ 
              bundle.putString("player_details_type", "a");
          }else {
              bundle.putString("player__details_type", "b");
          }
          bundle.putInt("player_details_health", nearbyPlayer.getHealth());
          playerDetailsFragment.setArguments(bundle);
          getSupportFragmentManager().beginTransaction().add(R.id.player_details_fragment_container, playerDetailsFragment).commit();
          return true;
      }
});