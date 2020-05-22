public List<DadosUsuario> findByUsuario(Usuario user) {
    Query q = currentSession().createQuery("from DadosUsuario d 
                  where d.id = user.id");
    List<DadosUsuario> allUsers = (List<DadosUsuario>) q.list();
    return allUsers;
}