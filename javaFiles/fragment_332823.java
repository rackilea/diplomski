public static void rescue() {
  int goodpos=0;
  int randompos=(int)(Math.random()*dailyPlanetStreet.size());

  for (int counter1=0; counter1<dailyPlanetStreet.size(); counter1++){
    if (dailyPlanetStreet.get(counter1).name()!="Kent Clark") {counter1=goodpos;}
  }

  dailyPlanetStreet.add(randompos,dailyPlanetStreet.remove(goodpos));
}