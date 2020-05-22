class Factory{
  public static <T> GenericObject<T> getSingleInstance()
  {
    return new GenericObject<T>();
  }

  public static <T> List<GenericObject<T>> getListOfInstance()
  {
    List<GenericObject<T> genericObjectList=new ArrayList<>();
    genericObjectList.add(new GenericObject<T>());
    genericObjectList.add(new GenericObject<T>());
    return genericObjectList;
  }
}