EditStudentForm edt = (EditStudentForm)form;
    if ((session.getAttribute("userList")) instanceof List){
    List <UserApplication> studtList = (ArrayList<UserApplication>)session.getAttribute("userList");
    }
    try {
    uaDAO.editUser(edt,studtList);
    action_forward = EDITSUCCESS;
    }