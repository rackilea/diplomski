if ((login==null)|(password==null)){
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
    requestDispatcher.forward(request, response);
} else {
    // Now we think that we are successfully logged in.

    // Yes, that above comment is now finally true.
    // Put your bunch of non-DRY if-else code here.
}