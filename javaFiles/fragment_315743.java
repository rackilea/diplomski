HttpSession session = request.getSession();
if (session.isNew()) {
    // Session is freshly created during this request.
} else {
    // Session was already created during a previous request.
}