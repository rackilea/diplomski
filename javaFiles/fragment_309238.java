Date date = null;

try {
    date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
}
catch (ParseException e) {
    // Show error message to enduser about the wrong format and forward back to the JSP with the form.
    request.setAttribute("error", "Invalid format, please enter yyyy-MM-dd");
    request.getRequestDispatcher("search.jsp").forward(request, response);
    return;
}