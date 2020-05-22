boolean stationFound = false;
while(inputFile.hasNextLine())
{
    // ...
    if(stationName.equalsIgnoreCase(name))
    {
        System.out.println("Station code: " + code + " name: " + name);
        System.out.println("distance " + distance + " kms, is on the " + line + " line");
        stationFound = true;
        break;
     }
}


if(!stationFound)
{
    System.out.println("No information was found for station " + stationName);
}