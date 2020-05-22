object LDAPValidations {

 def validateForLDAP(username: String, passcode: String): Boolean = {

val result = Try {
  var props = new Properties
  props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory")
  props.put(Context.PROVIDER_URL, "ldap://192.168.1.121:389")
  props.put(Context.SECURITY_PRINCIPAL, s"cn=$username,cn=staff,dc=myreutore,dc=local")
  props.put(Context.SECURITY_CREDENTIALS, "administrator")

  var context: InitialDirContext = new InitialDirContext(props)

  val controls: SearchControls = new SearchControls
  controls.setReturningAttributes(Array[String]("givenName", "sn", "memberOf", "cn"))
  controls.setSearchScope(SearchControls.SUBTREE_SCOPE)

  val answers: NamingEnumeration[SearchResult] = context.search("dc=myrtor,dc=local", s"cn=$username", controls)
  val result: SearchResult = answers.nextElement

  val user: String = result.getNameInNamespace
  props = new Properties
  props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory")
  props.put(Context.PROVIDER_URL, "ldap://192.168.1.121:389")
  props.put(Context.SECURITY_PRINCIPAL, user)
  props.put(Context.SECURITY_CREDENTIALS, passcode)
  context = new InitialDirContext(props)
}
result match {
  case Success(v) => true
  case Failure(v) => false
}