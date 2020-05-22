@Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
      //some logic
      response.sendRedirect(String.format("%s?error=true", getUrl());
    }
  }