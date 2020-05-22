if(bean == null){
          // EJB is not present in the HTTP session
          // so let's fetch a new one from the container
          try {
            InitialContext ic = new InitialContext();
            bean = (MyBean) 
             ic.lookup("java:global/MyBean");

            // put EJB in HTTP session for future servlet calls
            request.getSession().setAttribute(
              "myBean", 
              bean);

          } catch (NamingException e) {
            throw new ServletException(e);
          }
    }