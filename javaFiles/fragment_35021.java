public void setInterface(String[] interfaces) { 
  List<Class<?>> cls = new ArrayList<>();
  for (String i : interfaces) {
    try {
      cls.add(Class.forName(i));
    } catch (ClassNotFoundException ex) {
      // handle the error
    }
  }                              
  this.worker.setInterfaces(cls.toArray());  
}