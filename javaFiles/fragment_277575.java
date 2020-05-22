@RequestMapping(value="/")
  @Transactional
  public String getRespnse(Model m) {
        Session session =sessionFactory.getCurrentSession();
    //  List<User> usrLst=(List<User>) session.createQuery("from User");
    //  System.out.println("IN"+usrLst);
        return "home";
  }