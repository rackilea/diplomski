if (list.get(high).compareTo(pivot) < 0) 
{ 
    list.set(first, list.get(high));
    list.set(high,pivot);
    return high;
}