@Override
public int compareTo(DynamicField o) {
    int c = title.compareTo(o.title);
    if (c != 0)
      return c;
    if(position < o.position) 
        return -1;
    if(position > o.position)
        return 1;
    if(order < o.order)
        return -1;
    if(order > o.order)
        return 1;
    return 0;
}