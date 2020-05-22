protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        ArrayList<String> list = new ArrayList<String>();

        String name = request.getParameter("name");
        System.out.println("name=" + name);

        list.add(name);

        request.setAttribute("list", list);

        request.getRequestDispatcher("index.jsp").forward(request, response);

        // response.getWriter().append("name="+name+".Served at:
        // ").append(request.getContextPath());
    }