com.example.Dog dog = null;
  synchronized (application) {
    dog = (com.example.Dog) _jspx_page_context.getAttribute("dog", javax.servlet.jsp.PageContext.APPLICATION_SCOPE);
    if (dog == null){
      dog = new com.example.Dog();
      _jspx_page_context.setAttribute("dog", dog, javax.servlet.jsp.PageContext.APPLICATION_SCOPE);
      out.write("\n");
      out.write("     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("dog"), "breed", "House Dog !!!", null, null, false);
      out.write('\n');
    }
  }