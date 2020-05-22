public static String statistik(int[] fält) {
  String poäng[] = new String[fält.length];
  String output = "";

  //Clear out the array:
  for (int i = 0; i < poäng.length; i++) {
      poäng[i] = "";
  }

  //Add a star for each time a number appears
  for (int i = 0; i < fält.length; i++) {
    for (int t = 0; t < fält.length; t++) {
      if (fält[t] == i) {
        poäng[i] += "*";
      }
    }
  }

  //Print it out
  for (int i = 0; i < fält.length; i++) {
    output += i + ": " + poäng[i] + "\n";
  }
  System.out.println(output);
  return "";
}