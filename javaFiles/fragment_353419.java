BasicDataSource ds = new BasicDataSource();
...
ds.setPassword(userPassword);
ds.setUserName(login);
...

HttpSession session = request.getSession();
session.setAttribute("DBcon",ds);