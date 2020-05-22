@Test
   public void myTest()
   {
      HttpSession session = new MockHttpSession(new MockServletContext());
      ServletLifecycle.beginSession(session);

      ..testCode..

      // You can obtain a ServletContext (will actually be a MockServletContext 
      // implementation):
      ServletContext sc = session.getServletContext();
      URL url = sc.getResource("/WEB-INF/testdata.xml")
      Path resPath = new Path(url);
      File resFile = new File(url);
      FileReader resRdr = new FileReader(resFile);
      etc...

      ..testCode..

      ServletLifecycle.endSession(session);
   }