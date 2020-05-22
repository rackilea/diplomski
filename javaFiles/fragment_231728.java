private RecursiveMethodsList<T> retBetween(int index, T lowerValue, 
 T upperValue){
      if(index>=elements.size())return new RecursiveMethodsList<T>();

      RecursiveMethodsList<T> lst = retBetween(index+1,lowerValue,upperValue);

      if (elements.get(index).compareTo(lowerValue) >= 0 &&
         (elements.get(index).compareTo(upperValue)) <= 0)
             lst.elements.add(elements.get(index));


      return lst;

 }