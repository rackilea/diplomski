/**
  * Bundled Mock request
  */
MockHttpServletRequest request = new MockHttpServletRequest();
request.addParameter("name", "Tom");
request.addParameter("age", "25");

/**
  * Spring create a new command object before processing the request
  *
  * By calling <COMMAND_CLASS>.class.newInstance(); 
  */
Person person = new Person();