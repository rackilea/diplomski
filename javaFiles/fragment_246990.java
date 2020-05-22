@Transactional
public void add(Usuario usuario, Estado estado, Tipo tipo) {
    usuario.setEstado(estado);
    usuario.setTipo(tipo);
    usuarioDao.add(usuario);
}