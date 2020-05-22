try {

} catch(HibernateException e) {
  if(e instanceof ConstraintViolationException) {
    ConstraintViolationException ce = (ConstraintViolationException) e;
    String constraintName = ce.getConstraintName();
  }
}