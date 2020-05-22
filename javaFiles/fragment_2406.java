@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) {

    // handle upload

    // if error
    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

    // or
    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                       "An unknown error occurred");
}