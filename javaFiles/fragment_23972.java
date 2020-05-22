Object element = null;
    Field f = null;
    if(list.size()>0)
    {
      Class<?> c = list.get(0).getClass();
      try {
        f = c.getDeclaredField(field);
        f.setAccessible(true);
    } catch( NoSuchFieldException e ) {
        e.printStackTrace();
    }

    int size = list.size();
    for( int i = 0; i < size; i++ ) {
        element = list.get(i);
        try {
            if( s.equals(f.get(element))) {
                result = false;
                break;
            }
        } catch( IllegalArgumentException e ) {
            e.printStackTrace();
        } catch( IllegalAccessException e ) {
            e.printStackTrace();
        }
    }

    return result;
}else
{
  return true;
}