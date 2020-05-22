public void searchUser() {
if (action.equals("searchUser")) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    String searchQuery = request.getParameter("searchQuery");
    String[] params = searchQuery.split(" ");

    // Found users
    List<User> usersFound = new ArrayList<User>();

    // Exact match
    String hqlMatch = this.getSearchHqlQuery(params, "AND");
    List<User> exactResult = session.createQuery(hqlMatch).list();
    if (exactResult!=null && !exactResult.isEmpty()) {
        usersFound.addAll(exactResult);
    }
    // Multiple search
    else {
        String hqlLike = this.getSearchHqlQuery(params, "OR");
        List<User> likeResult = session.createQuery(hqlLike).list();
        if (likeResult!=null && !likeResult.isEmpty()) {
            usersFound.addAll(likeResult);
        }
    }

    System.out.println("size:" + usersFound.size());
        // set our results on the request and redirect back
        request.setAttribute("users", usersFound);
        request.setAttribute("usersSize", usersFound.size());
        request.setAttribute("usersSizeResults", usersFound.size());

        redirect(request, response, "/search.jsp");
        session.close();
    }
}

private String getSearchHqlQuery(String[] params, String andOrfilter) {
    StringBuilder hql = new StringBuilder();
    hql.append("from User ");
    if (params.length > 0) {
        hql.append("where ");
        for (int i = 0; i < params.length; i++) {
            if (i > 0) { hql.append(andOrfilter); }
            hql.append(" (username like '%").append(params[i]);
            hql.append("%' OR firstname like '%").append(params[i]);
            hql.append("%' OR lastname like '%").append(params[i]);
            hql.append("%' OR emailAddress like '%").append(params[i]);
            hql.append("%') ");
        }
    }
    return hql.toString();
}