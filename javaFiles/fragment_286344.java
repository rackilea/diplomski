for (int k = 0; k < size; k++) {
    String valuesStrArr2[] = s.nextLine().split(",");
    int coord1 = Integer.parseInt(valuesStrArr2[0]); 
    int coord2 = Integer.parseInt(valuesStrArr2[1]); 
    City city = new City(coord1, coord2);
    TourManager.addCity(city);
}