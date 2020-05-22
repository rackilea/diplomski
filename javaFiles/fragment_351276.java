for(Map.Entry<Object, Integer> pair : something.entrySet()) {
    List<String> methods = pair.getkey().serviceList;
    if(methods.contains(methodName) {
      does something
      break;
    }
}