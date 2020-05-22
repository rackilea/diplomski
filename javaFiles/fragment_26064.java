public void setID (String id)
    throws SomeException
  {
    if (id==null)
      throw new SomeException();

    try {
      setID (Integer.valueOf (id));
    }
    catch (NumberFormatException intEx) { // catch unchecked exception
      throw new SomeException(id, intEx); // throw checked exception
    }
  }