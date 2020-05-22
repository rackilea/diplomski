HttpSession session = ((HttpServletRequest) request).getSession();
SessionBean sessionBean = (SessionBean) session.getAttribute("sessionBean");

if (sessionBean == null) {
    sessionBean = new SessionBean();
    session.setAttribute("sessionBean", sessionBean);
}

// ...

sessionBean.setRole(role);

// ...