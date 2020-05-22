public Laudo buscarLaudoPorCodigo(Long idLaudo) {
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    try {
        Criteria consulta = sessao.createCriteria(Laudo.class);
        consulta.add(Restrictions.idEq(idLaudo));
        Laudo resultado = (Laudo) consulta.uniqueResult();  
        return resultado;
    } catch (RuntimeException erro) {
        throw erro;
    } finally {
        sessao.close();
    }
}