String[] countryList = new String[country];
int[] numVisits = new int[country];

System.out.println("Here is another look of your data:");
    StringBuilder asteriskConvert;
    for (int index = 0; index < countryList.length; index++)
    {
        asteriskConvert = new StringBuilder();
        for (int i = 0; i < numVisits[index]; i++)
        {
            asteriskConvert.append("*");
        }
        System.out.println(countryList[index] + " " + asteriskConvert.toString());
    }