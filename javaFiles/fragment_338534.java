public int getBusIndex(String myButtonText)
{
String[] bus = context.getResources().getStringArray(R.array.bus_routes);
    for(String s: bas)
    {
     if(s.contains(myButtonText))   //simple linear search
         return Integer.parseInt(s);
    }

return -1;// if the search is not successfull (also try to implement more faster searches, see Collections class)
}