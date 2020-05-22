protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

           String fruits = request.getParameter("Values");
            ArrayList<String> fruitsList1 = new ArrayList<String>();
           //get values which are in session
            ArrayList<String> fruitsList = (ArrayList<String>)request.getSession().getAttribute("List");

              //if attribute value is not null 
            if (fruitsList != null) {
               //add new values
                fruitsList.add(fruits);
                request.getSession().setAttribute("List", fruitsList);
                RequestDispatcher rs = request.getRequestDispatcher("form.html");
                rs.forward(request, response);

            } else if (fruitsList== null) {
               //adding value selected in array list
                fruitsList1.add(fruits);
                 //setting values
                request.getSession().setAttribute("List", fruitsList1);
                RequestDispatcher rs = request.getRequestDispatcher("form.html");
                rs.forward(request, response);
            } else{

             //remove values 
         }

        }