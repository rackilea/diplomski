try {
    ..potentiall throws exceptions...
} catch (Exception e) {
    RuntimeException re = new RuntimeException(e);
    re.setStackTrace(e.getStackTrace());
    throw re;
}