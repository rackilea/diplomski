public String view() {
  UserDao userDao = new UserDao();
  List<UseBean> users = userDao.getAllUsers();
  ServletActionContext.getRequest().setAttribute("users", users);
  return Action.SUCCESS;
}

public String update() {
  UserDao dao = new UserDao();
  UseBean bean=new UseBean();
  HttpServletRequest request ServletActionContext.getRequest();
  bean.setID(request.getParameter("ID");
  bean.setName(request.getParameter("Name");
  bean.setPassword(request.getParameter("Password");
  bean.setPhoneo(request.getParameter("Phoneo");
  bean.setEmailID(request.getParameter("EmailID");
  //System.out.println(getName()+""+getPassword()+""+getPhoneo()+""+getEmailID());
  dao.updateUser(bean);
  return Action.SUCCESS;

}

public String delete() {
  HttpServletRequest request ServletActionContext.getRequest();
  int userId = request.getParameter("ID");
  dao.deleteUser(userId);
  return Action.SUCCESS;
}