List<Dvd> dvds = new ArrayList<Dvd>;
try {
    final String nickname = request.getParameter("nickname");
    if (nickname != null) {
        final User user = this.userDao.getByLogin(nickname);
        if (user != null) {
            dvds = this.dvdDao.getDvdsByUserId(user.getId());
        } else {
            // handle non-existent user
        }
    } else {
        // handle no "nickname" parameter was present
    }
} catch (SQLException e) {
    throw new ServletException("Unable to get dvds", e);
}

request.setAttribute("dvds", dvds);
final RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/loans.jsp");
dispatcher.forward(request, response);