HttpSession session = request.getSession();
List<String> list = new ArrayList<String>();

if (session.isNew()) {
    list.add(name);
    session.setAttribute("list", list);
} else {
    list = (List<String>) session.getAttribute("list");
    list.add(name);
    session.setAttribute("list", list);
}