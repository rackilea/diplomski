private void redirect(ResponsePage aDestinationPage, HttpServletResponse aResponse) throws IOException {
    String urlWithSessionID = aResponse.encodeRedirectURL(aDestinationPage.toString());
    aResponse.sendRedirect( urlWithSessionID );
}

private void forward(ResponsePage aResponsePage, HttpServletRequest aRequest, HttpServletResponse aResponse) throws ServletException, IOException {
    RequestDispatcher dispatcher = aRequest.getRequestDispatcher(aResponsePage.toString());
    dispatcher.forward(aRequest, aResponse);
}