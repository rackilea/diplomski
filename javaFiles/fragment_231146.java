Address jobAddress = LatLng.getAdrressFromLatLng(this, myLatLng);
StringBuilder address = new StringBuilder("");

address.append(jobAddress.getThoroughfare()).append(", ");  // 740 Park Avenue
address.append(jobAddress.getLocality()).append(", ");      // New York
address.append(jobAddress.getPostalCode());                 // 10021