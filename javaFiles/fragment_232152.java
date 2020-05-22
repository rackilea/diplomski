public void verificarUsuario() {
//UsuarioJpaController usuarioJPA = new UsuarioJpaController();
usuarioJPA.getEntityManager().createNamedQuery("Usuario.findByLoginSenha").setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getResultList();

  if(canLogin){ //canLogin is the condition to check whether can login or not
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/home.xhtml");
  }
  else{
       showAlert = true;
  }
}