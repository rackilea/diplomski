protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        SessionFactory factory = session.getSessionFactory();
        Session s = factory.openSession(); 
        List<Message> messages = s.createQuery("FROM Message").list();

        //associate with a request attribute
        request.setAttribute("messages", message);

        //forward to your JSP
        request.getRequestDispatcher("messages.jsp").forward(request, response);
    }