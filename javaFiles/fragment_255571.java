public void init(ServletConfig sc){
   try {
      super.init(sc);
      list = new ArrrayList<String>();
      Enumeration<String> e= sc.getInitParameterNames();
      while(e.hasMoreElements()){
         list.add(e.nextElement());
      }
   } catch (ServletException e1) {
    e1.printStackTrace();
   }
}