//  create a class for saving latitude and longitude under any package
        private class Cordinate
        {
        double lati,longi;

        public Cordinate(double la,louble lo)
        {
           lati=la;
           longi=lo;
        }
        // set getters and setters for this two variables
        public double getLati() {
    return lati;
}

public void setLati(double lati) {
    this.lati = lati;
}

public double getLongi() {
    return longi;
}

public void setLongi(double longi) {
    this.longi = longi;
}



        }
        //define array list for saving the latitude and longitude
        List<Cordinate> cordinateList = new ArrayList<Cordinate>();


        // then inside your functn
        for (Route route : allRoute) {
                Log.d("Car: ", route.getDate());

                cordinateList.add(new Cordinate(route.getLattitude,rout.getLongitude));
                for (int i = 0; i < lat.size(); i++) {//and this is where I cant find a solution.
                    String element = lat.get(i);
                    double value = Double.parseDouble(element);
                }
    // then call the method CalculateDistance () by passing variables
    // You can use cordinate variables for setting the location object
    //  for ex: loc.setLatitude(cordinateList(i).getLati());
    //          loc.setLatitude(cordinateList(i).getLongi()); 


        // method for find distance
        CalculateDistance(Location loc1,Location dest)
        {
          double distance=DistanceCalculator.getDistance(loc, dest);
                        distance=Math.round(distance * 100.0) / 100.0;
        }