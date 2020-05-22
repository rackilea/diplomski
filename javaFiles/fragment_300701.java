Comparator<MyObject> comparator = new Comparator<MyObject>(){
    @Override
    public int compare(final MyObject o1, final MyObject o2){
       if(!o1.getCity().equals(o2.getCity())){
          return o1.getCity().compareTo(o2.getCity());
       }else{
          return o1.getAge().compareTo(o2.getAge());
        }
    }
  };

Collections.sort(myArrayList,comparator);