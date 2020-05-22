public static <T> List<T[]> splitListIntoArrays(List<T> list, int divisor, Class<T> clazz)
  {
    ArrayList<T> listSplit = new ArrayList<>();
    ArrayList<T[]> listOfArrays = new ArrayList<>();
    for (int i = 0; i < list.size(); i++)
    {
        listSplit.add(list.get(i));
        if ((listSplit.size() + divisor) % divisor == 0 || i == (list.size() - 1))
        {
          @SuppressWarnings("unchecked")
          T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, listSplit.size());

          listOfArrays.add(listSplit.toArray(array));
          listSplit = new ArrayList<>();
        }
    }
    return listOfArrays;
  }