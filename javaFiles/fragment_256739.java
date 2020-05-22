public static PersistenceMicrodataException dealHibernateException(Throwable e) {
    String concatError = ((SQLGrammarException) e).getSQL() + ((SQLGrammarException) e).getClass() + ((SQLGrammarException) e).getCause();
    while (e != null) {
        java.lang.System.out.println(concatError);
        break;
    }           
    Throwable t = ExceptionUtil.getCause(e);
    return new PersistenceMicrodataException(concatError,t);
}