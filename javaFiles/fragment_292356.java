protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    try {
        // Fetch the user-sent parameters (operands)
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        // Calculate the result of this operation
        int result = calculator.add(operand1, operand2);

        // Put the result as an attribute (JSP will use it)
        request.setAttribute("result", result);
    } catch (NumberFormatException ex) {            
        // We're translating Strings into Integers - we need to be careful...
        request.setAttribute("result", "ERROR. Not a number.");
    } finally {            

        // No matter what - dispatch the request back to the JSP to show the result.
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
    }
}