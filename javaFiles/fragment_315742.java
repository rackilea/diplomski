HttpSession session = request.getSession(false);
if (session == null) {
    // Session is not created.
} else {
    // Session is already created.
}