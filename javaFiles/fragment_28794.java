For the user name, the manager uses the Session.getPrincipal() if available; 
if not, it tries the following Session attribute names:
  Login
  User
  userName
  UserName
  Utilisateur
using the given case, lower case, and upper case.  Failing that, it searches for
attributes that are instances of java.security.Principal or
javax.security.auth.Subject.