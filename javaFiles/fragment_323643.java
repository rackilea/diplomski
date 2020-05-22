Session session = Session.getActiveSession();
if (!session.isOpened()) {
    session.openForRead(...);
} else {
    Session.openActiveSession(...);
}