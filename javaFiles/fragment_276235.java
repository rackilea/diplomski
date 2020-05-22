Enumeration reqParams= request.getParameterNames();
while (reqParams.hasMoreElements()) {
    String key= (String) reqParams.nextElement();
    String val = request.getParameter(element);
    System.out.println(" Key ==> "+key+" , Value ==> "+val);

}