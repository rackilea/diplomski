public static void main (String[] args) throws java.lang.Exception
  {
    String [] countries = {"Egypt", "France", "Japan", "Switzerland"};
    int[] populations = {92592000, 66991000, 126860000, 8401120};
    printTable(countries, populations);
  }

  public static void printTable(String[] countries, int[] populations){
    int countryLength = 0;
    long populationLength = 0;

    for(String country: countries){ //get longest country
      if (country.length() > countryLength)
        countryLength = country.length();
    }
    for(int i : populations) { //get longest number
      if(String.valueOf(i).length() > populationLength)
        populationLength = String.valueOf(i).length();
    }

    for(int i = 0; i < countries.length; i++) // print it out
      System.out.format("%-"+ (countryLength+1) +"s|%" + (populationLength+1) +"d\n",countries[i], populations[i]);
  }