MockHttpServletRequest request = new MockHttpServletRequest();
request.setScheme("https");
request.setServerName("mycompany.com");
request.setServerPort(443);
request.setRequestURI("/myapp.php");

System.out.println(request.getRequestURL());
// Prints: https://mycompany.com/myapp.php