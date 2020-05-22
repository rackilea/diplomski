<security-domains>
....
  <security-domain name="jmx-console" cache-type="default">
  <authentication>
  <login-module code="org.jboss.security.auth.spi.UsersRolesLoginModule" flag="required">
  <module-option name="usersProperties" value="${jboss.server.config.dir}/jmx-console- users.properties"/>
  <module-option name="rolesProperties" value="${jboss.server.config.dir}/jmx-console- roles.properties"/>
  </login-module>
  </authentication>
  </security-domain>
</security-domains>