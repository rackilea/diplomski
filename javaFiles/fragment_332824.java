public static void rescue() {
  int goodPos = 0;
  int randomPos = (int)(Math.random() * dailyPlanetStreet.size());

  for (int counter1 = 0; counter1 < dailyPlanetStreet.size(); counter1++) {
    if (!"Kent Clark".equals(dailyPlanetStreet.get(counter1).name())) {
      goodPos = counter1;
    }
  }

  dailyPlanetStreet.add(randomPos, dailyPlanetStreet.remove(goodPos));
}