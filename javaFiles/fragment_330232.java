protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer value=15;
        request.setAttribute("value", value);
        request.getRequestDispatcher("CharttestCanvas3.jsp").forward(request, response);
        }