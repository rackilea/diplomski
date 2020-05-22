public void displayAdjacentCities(City aCity) { 
  for(int x = 0; x < size; x++) {
    if (aCity.getName().equalsIgnoreCase(allCities[x].getName())) {
       if (adjacents[x].size() == 0) continue;
       System.out.print(aCity.getName());
       for (City other : adjacents[x]) {
                System.out.print("   >>>   " + other.getName()); 
            }
            System.out.println();
        }
    }
}