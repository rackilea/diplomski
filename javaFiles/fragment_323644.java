Session session = Session.getActiveSession();
if (session == null) {
    Session.openActiveSession(...);
} else if (!session.isOpened()) {
    session.openForRead(...);
}