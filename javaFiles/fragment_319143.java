protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    StudentDao studentDao = new StudentDao();
    ArrayList<StudentBean> studentList = studentDao.getStudent();

    //added here
    request.setAttribute("studentList", studentList);

    request.getRequestDispatcher("/Student.jsp").forward(request, response);
}