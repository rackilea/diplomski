public static boolean compareLists(List<Car> prevList, List<Car> modelList) 
{
    boolean listEquals = true;
    if (prevList!= null && modelList!=null && prevList.size() == modelList.size()) 
    {
        for (Car modelListdata : modelList) 
        {
            boolean elementInList = false;
            for (Car prevListdata : prevList) 
            {
                if (prevListdata.getCarName().equals(modelListdata.getCarName()) && prevListdata.getCarNumber() == modelListdata.getCarNumber()) 
                {
                    /* The list has the element, set the flag to true and break the loop */ 
                    elementInList = true;
                    break;
                }
            }
            if (elementInList == false) {
                /* There is one element not found in the second list, the lists are not equals */
                listEquals = false;
                break;
            }
        }            
        return listEquals;
    } else {
        /* At least one list is null or the size is not the same */
        return false;
    }
}