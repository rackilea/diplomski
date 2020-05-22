public static List<Integer> sqInRec (int length, int width) {
    List<Integer> list = new ArrayList<>();
    while(length!=width){
          if(length>width){
             length = length-width;
             list.add(width);
          }else{
              width = width- length;
              list.add(length);
          }
    }
    if(list.size()>0){
          list.add(length);
          return list;
    }

    return null;
}