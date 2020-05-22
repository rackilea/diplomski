public int findRow(double targetTemperature, int ch)
{
    //This method takes a double and finds it in the List, it then returns the element in which it is (the row)
    //The element returned can be used with duration.between to find the response time between 2 known values
    for (int i=0; i < readings.size(); i++)
    {
            double compareTemp = readings.get(i).getValue(ch);
            if (compareTemp > targetTemperature)
            {
                System.out.println(readings.get(i).getTimestamp() + "is above target temp for channel " + ch);
                return i;
            }
    }
    System.out.println(readings.get(i).getTimestamp() + "Is not 
            above target temp for channel " + ch);
    return -1;
}