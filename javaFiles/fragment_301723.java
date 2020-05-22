public int cols() {
      if ( table.size() > 0 )
    return table.get(0).size();
      else
          return 0;
  }



public void addRow(int i) {
    if (i < 0 || i > rows()) throw new IndexOutOfBoundsException();

    List<T> list = new ArrayList<T>();
    for ( int j = 0; j < cols(); j++ )
    {
        list.add( null );
    }
    table.add(i, list);
  }