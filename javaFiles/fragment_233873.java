SecurityContextHolder.getContext().setAuthentication(null);
    try {
        request.logout();
    } catch (ServletException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


    request.getSession().invalidate();