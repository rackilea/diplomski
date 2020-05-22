HttpSession session = request.getSession();
List<String> list = (List<String>) session.getAttribute("list");

if (list == null) {
    list = new ArrayList<String>();
    session.setAttribute("list", list);
}

list.add(name);