int length = CitiesInfos.citiesOnTheRoad.length;
    for (int i = 0; i < length; i++)
    {
        HashMap<String,String> temp=new HashMap<String, String>();
        temp.put(FIRST_COLUMN, CitiesInfos.citiesOnTheRoad[i]);
        if(i < CitiesInfos.roadWorkArrayList.size() 
            && i < CitiesInfos.weatherArrayList.size() 
            && CitiesInfos.roadWorkArrayList.get(i)!=null)
        {
            temp.put(SECOND_COLUMN, CitiesInfos.weatherArrayList.get(i).getCelcius() + ", " + CitiesInfos.weatherArrayList.get(i).getWeatherStatus());
        }
        else
        {
            temp.put(SECOND_COLUMN, " ");
        }
}