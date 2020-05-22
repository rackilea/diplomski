protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        boolean exist = customerExist(firstName, lastName);
        request.setAttribute("customerExist", exist);
    }