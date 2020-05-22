private int count; 

    public Resolution add() throws BaseException {
       HttpSession session=request.getSession();
       int count=(Integer)session.getAttribute("count");
      if ( count >= 5 ) {
        doSomething();
      }

      if ( true ) {
        count++;

        session.setAttribute("count",count);
        throw BaseValidationException();
      }

      return view( );
    }