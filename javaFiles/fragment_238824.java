public static <T> List<T[]> splitListIntoArrays(List<T> list, int divisor)
  {
    ArrayList<T> listSplit = new ArrayList<>();
    ArrayList<T[]> listOfArrays = new ArrayList<>();
    for (int i = 0; i < list.size(); i++)
    {
        listSplit.add(list.get(i));
        if ((listSplit.size() + divisor) % divisor == 0 || i == (list.size() - 1))
        {
          listOfArrays.add(listSplit.toArray(new T[listSplit.size()]));
          listSplit = new ArrayList<>();
        }
    }
    return listOfArrays;
  }