catch(IllegalArgumentException e) {
    Throwable t = e;
    while (t != null)
    {
        if (t instanceof PSQLException) {
              PSQLException pe = (PSQLException)t;
             // analyse the exception
             break;
        }
        t = t.getCause();
    }
}