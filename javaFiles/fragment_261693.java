/**
  * And then with a ServletRequestDataBinder, it binds the submitted values
  * 
  * It makes use of Java reflection To bind its values
  */
ServletRequestDataBinder binder = new ServletRequestDataBinder(person);
binder.bind(request);