public void onInfoWindowClick(Marker marker) {

        if("India".equals(marker.getTag())) {
            Intent intent = new Intent(this,India.class);
            startActivity(intent);
        } else if("Sydney".equals(marker.getTag())) {
            // showToast() or whatever you want to   
        }
    }