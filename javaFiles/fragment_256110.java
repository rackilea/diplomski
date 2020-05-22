public static boolean compareListsEquals(List<Car> prevList, List<Car> modelList) 
{
    if (prevList!= null && modelList!=null && prevList.size() == modelList.size()) 
    {
        for (Car modelListdata : modelList) 
        {
            if (prevList.contains(modelListdata) == false) {
                return false;
            }
        }            
        return true;
    } else {
        /* At least one list is null or the size is not the same */
        return false;
    }
}