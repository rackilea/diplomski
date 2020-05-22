private RecursiveMethodsList<T> retBetween(RecursiveMethodsList<T> list, int index, T lowerValue, T upperValue){
    if(index>=elements.size())return list;
    if (elements.get(index).compareTo(lowerValue) >= 0 &&
       (elements.get(index).compareTo(upperValue)) <= 0)
            list.elements.add(elements.get(index));

    return retBetween(list, index+1, lowerValue, upperValue);
}