NewFileThing fi = NewFileThing();
fi.addName(name);

// get the session
HttpSession session = request.getSession();
session.setAttribute("NewFileThing", fi);