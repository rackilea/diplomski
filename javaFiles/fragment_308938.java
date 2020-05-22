Enumeration en=request.getParameterNames();
 while(en.hasMoreElements())
 {
  Object objOri=en.nextElement();
  String param=(String)objOri;
  String value=req.getParameter(param);
  pw.println("Parameter Name is '"+param+"' and Parameter Value is'"+value+"'");
 }