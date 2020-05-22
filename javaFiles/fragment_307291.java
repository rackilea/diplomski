grant codeBase "file:/C:/Codebase/-" {
   permission javax.security.auth.AuthPermission "doAsPrivileged";
   permission javax.security.auth.AuthPermission "createLoginContext.TestLdap";
};

grant codeBase "file:/C:/Deveop/Codebase2/-", 
principal com.sun.security.auth.UserPrincipal "john" {
  permission java.util.PropertyPermission "user.home", "read";
  permission java.util.PropertyPermission "java.home", "read";

};