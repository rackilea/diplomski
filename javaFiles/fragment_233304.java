private String userName;

    private String userPassword;

    private String mensaje ="";

public void validar(String usuario, String password) {

        try {
//Este metodo funciona para validar el usuario, 
//si el usuario tiene nombre y pass correcto devuelve un OK 
//Si el usuario da error entonces cierra la conexion 


//Generamos el DN        
final String dn = "uid=" + usuario +",ou=users,cn=admin,dc=organizacion,dc=com,dc=uy";

//Solicitamos el bindRequest creando una nueva instancia y de parametros el dn y pass
        final BindRequest bindRequest = new SimpleBindRequest(dn, password);
//Nos conectamos al server
        final LDAPConnection ldapConnection = new LDAPConnection("192.168.1.1", 389);
//Intentamos hacer el bind
        final BindResult bindResult = ldapConnection.bind(bindRequest);
//Obtenemos el resultcode de la funcion anterior (SUCCESS o FAIL)
        final ResultCode resultCode = bindResult.getResultCode();



//Si el resultado es SUCESS entonces metemos el codigo aca
// podemos iniciar una sesion, pasar valores a un session bean, etc
        if (resultCode.equals(ResultCode.SUCCESS)) {

            this.mensaje = "Validacion correcta";
        } else {

            //Damos un error y cerramos la conexion
             this.mensaje = "Validacion incorrecta";

            ldapConnection.close();

        }
        } catch (Exception e) {
            this.mensaje = "Mensaje de error";

        }