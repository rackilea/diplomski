String param = request.getParameter("param");
if (session.getAttribute("PARAM") == null) {
    out.print("This is a NEW request");
    session.setAttribute("PARAM", request.getParameter("param"));
} else if (session.getAttribute("PARAM").toString().equalsIgnoreCase(param)) {
    out.print("This is a REFRESH");
    session.removeAttribute("PARAM");
} else {
    out.print("This is a NEW request");
    session.setAttribute("PARAM", request.getParameter("param"));
}