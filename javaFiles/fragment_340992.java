@Override
public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {  
    for(String name : request.getParameterMap().keySet()){
      for(String value : request.getParameterValues(name)){
          System.out.println(name +": " + value);        
      }
    }
}