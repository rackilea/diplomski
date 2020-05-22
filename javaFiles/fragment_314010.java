@SuppressWarnings("unchecked")
@Transactional
public List<E> findByStringField(String field, String value) {
    String expressao = entity.toString();
    String nome_classe = new String();
    StringTokenizer st = new StringTokenizer(expressao);
    while (st.hasMoreTokens()) {
        nome_classe = st.nextToken();
    }
    String query = "from "+nome_classe+" where "+field+" = :data";
    List<E> instance = sessionFactory.getCurrentSession().createQuery(query).setString("data", value).list();
    return instance;
}

@SuppressWarnings("unchecked")
@Transactional
public List<E> findByIntegerField(String field, Integer value) {
    String expressao = entity.toString();
    String nome_classe = new String();
    StringTokenizer st = new StringTokenizer(expressao);
    while (st.hasMoreTokens()) {
        nome_classe = st.nextToken();
    }
    String query = "from "+nome_classe+" where "+field+" = :data";
    List<E> instance = sessionFactory.getCurrentSession().createQuery(query).setInteger("data", value).list();
    return instance;
}