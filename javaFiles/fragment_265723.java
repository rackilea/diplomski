public static void main(String[] args)
  {
    String countryNames = "CHINA,RUSSIAN FEDERATION, THE,INDIA,MALAYSIA";
    List<String> countriesList = new ArrayList<>();

    int startIndex = 0, endIndex = 0;
    char[] chararray = countryNames.toCharArray();
    String str = "";
    for (char ch : chararray)
    {
      if (endIndex > 0)
      {
        //Find only those commas whose nearby with characters only. Example : E,I
        if (ch == ',' && (chararray[endIndex - 1] >= 'A' && chararray[endIndex - 1] <= 'Z')
            && (chararray[endIndex + 1] >= 'A' && chararray[endIndex + 1] <= 'Z'))
        {
          str = "";
          for (int i = startIndex; i < endIndex; i++)
          {
            str += chararray[i];
          }
          countriesList.add(str);
          startIndex = endIndex + 1;
        }
      }
      endIndex++;
    }
    str = "";
    //Add last segment of the string.
    for (int i = startIndex; i < endIndex; i++)
    {
      str += chararray[i];
    }
    countriesList.add(str);

    //Displaying list.
    for (String s : countriesList)
      System.out.println(s);
  }