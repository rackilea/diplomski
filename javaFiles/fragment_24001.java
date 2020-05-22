if (result.next()) { 
    // ...
} else {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    response.getWriter().print("File not found for the file id: " + course_code);  
}