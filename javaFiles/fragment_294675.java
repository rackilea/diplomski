@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

          UserDAO u = new UserDAO(); //instantiate class

       //get our list of users
     List<UserBean> users = u.adminPanel();
       //set our list to request
     request.setAttribute("memberList", users);

     //forward to jsp page
        RequestDispatcher rs = request.getRequestDispatcher("AdminPanel.jsp");
            rs.forward(request, response);


    }