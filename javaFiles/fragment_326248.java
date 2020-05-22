public static void listCountryMedals(String[] country, int[] totalMedals) {
  boolean[]seen = new boolean[country.length];
  for (int i = 0; i < country.length - 1; i++) {
      int medals = totalMedals[i];
      if (!seen[i]) {
          for(int j = i + 1; j < country.length; j++) {
             if (country[i].equals(country[j])) {
                 medals += totalMedals[j];
                 seen[j] = true; //I already took this country
             }
          }
          System.out.println(country[i] + ", " + medals + " medal(s)");
      }
      seen[i] = true;
  }
}