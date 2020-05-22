public void addPlanet(Planet p) {
  if (solarSystem.size() == 0) {
     solarSystem.add(p);
  } else {
     for (int i = 0; i < solarSystem.size(); i++) {
        if (p.getOrbital() < solarSystem.get(i).getOrbital()) {
           solarSystem.add(i, p);
           return; // adding planet is complete so we will exit the method here
        }  
     }
     // if we're here, the planet must be larger than all others
     // so we will add the planet at the end of the array
     solarSystem.add(p);
  }
}